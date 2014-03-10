package glenn.dao;


import glenn.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
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
    private EntityManager entityManager;

    @Mock
    Query query;

    @Mock
    private EntityTransaction transaction;

    @Test
    public void testGetProducts() {

        String qs = "from Product order by id";
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
        when(entityManager.createQuery(qs)).thenReturn(query);
        when(query.getResultList()).thenReturn(productList);
        productDao = new ProductDaoImpl(entityManager);
        List<Product> products = productDao.getProducts();
        verify(entityManager).createQuery(qs);
        verify(query).getResultList();
        assertEquals(products.size(),3);



    }
    
    @Test
    public void testSaveProjects() {
        Product p = new Product();
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        when(entityManager.getTransaction()).thenReturn(transaction);
        productDao = new ProductDaoImpl(entityManager);
        productDao.saveProduct(p);
        verify(entityManager).getTransaction();
        verify(transaction).begin();
        verify(entityManager).persist(p);
        verify(transaction).commit();
    }

    @Test
    public void testGetById() {
        productDao = new ProductDaoImpl(entityManager);
        Product p = new Product();
        p.setId(1);
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        when(entityManager.getReference(Product.class,(long) 1)).thenReturn(p);

        Product p2 = productDao.get((long) 1);
        verify(entityManager).getReference(Product.class,(long) 1);
        assertEquals(p,p2);

    }

    @Test
    public void testDeleteProject() {
        productDao = new ProductDaoImpl(entityManager);
        Product p = new Product();
        p.setId(1);
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        when(entityManager.getTransaction()).thenReturn(transaction);
        productDao.delete(p);
        verify(entityManager).getTransaction();
        verify(transaction).begin();
        verify(entityManager).remove(p);
        verify(transaction).commit();
    }
    

}
