package glenn.dao;


import glenn.model.Product;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ycv6026 on 3/3/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestProductDao {
    private ProductDao productDao;
    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session session;

    @Mock
    private Query query;



    @Test
    public void testGetProducts() {

        String qs = "select p from Product order by id";
        List<Product> productList = new ArrayList<Product>();
        Product p1 = new Product();
        p1.setName("Purina Cat Food");
        p1.setType("Cat Food");
        p1.setCost(5.00);
        p1.setListPrice(10.00);
        productList.add(p1);
        Product p2 = new Product();
        p2.setName("Purina Dog Food");
        p2.setType("Dog Food");
        p2.setCost(5.00);
        p2.setListPrice(10.00);
        productList.add(p2);
        Product p3 = new Product();
        p3.setName("Catnip Mouse");
        p3.setType("Cat Toy");
        p3.setCost(1.00);
        p3.setListPrice(2.00);
        productList.add(p3);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.createQuery(qs)).thenReturn(query);
        when(query.list()).thenReturn(productList);
        productDao = new ProductDaoImpl(sessionFactory);

        List<Product> products = productDao.getProducts();
        verify(sessionFactory).getCurrentSession();
        verify(session).createQuery(qs);
        verify(query).list();



    }
    
    @Test
    public void testSaveProjects() {
        Product p = new Product();
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        productDao = new ProductDaoImpl(sessionFactory);
        productDao.saveProduct(p);

        verify(sessionFactory).getCurrentSession();
        verify(session).saveOrUpdate(p);

    }

    @Test
    public void testGetById() {
        productDao = new ProductDaoImpl(sessionFactory);
        Product p = new Product();
        p.setId(1);
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        when(sessionFactory.getCurrentSession()).thenReturn(session);
        when(session.get(Product.class,(long) 1)).thenReturn(p);

        Product p2 = productDao.get((long) 1);
        verify(sessionFactory).getCurrentSession();
        verify(session).get(Product.class,(long) 1);
        assertEquals(p,p2);

    }
    

}
