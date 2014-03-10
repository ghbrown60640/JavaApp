package glenn.dao;


import glenn.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static junit.framework.Assert.assertEquals;


/**
 * Created by ycv6026 on 3/3/14.
 */
public class ITTestProductDao {
    private EntityManager entityManager;
    private ProductDao productDao;

    @Before
    public void setUp() throws Exception {
        entityManager=Persistence.createEntityManagerFactory("hsqldb-ds").createEntityManager();
        productDao = new ProductDaoImpl(entityManager);

    }

    @After
    public void tearDown() throws Exception {

        entityManager.close();
    }

    @Test
    public void testSaveProducts() {
        Product p = new Product();
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);

        
        productDao.saveProduct(p);
        assertEquals(productDao.getProducts().size(),1);


    }

    @Test
    public void testGetProducts() {


        String qs = "select p from Product order by id";
        Product p1 = new Product();
        p1.setName("Purina Cat Food");
        p1.setType("Cat Food");
        p1.setCost(5.00);
        p1.setListPrice(10.00);
        productDao.saveProduct(p1);
        Product p2 = new Product();
        p2.setName("Purina Dog Food");
        p2.setType("Dog Food");
        p2.setCost(5.00);
        p2.setListPrice(10.00);
        productDao.saveProduct(p2);
        Product p3 = new Product();
        p3.setName("Catnip Mouse");
        p3.setType("Cat Toy");
        p3.setCost(1.00);
        p3.setListPrice(2.00);
        productDao.saveProduct(p3);


        List<Product> products = productDao.getProducts();

        assertEquals(products.size(),3);    }
    


    @Test
    public void testGetById() {
        Product p = new Product();
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        productDao.saveProduct(p);
        Product p2 = productDao.get(p.getId());

        assert(p.equals(p2));

    }

    @Test
    public void testDeleteProduct() {
        Product p = new Product();
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        productDao.saveProduct(p);
        int originalSize=productDao.getProducts().size();
        productDao.delete(p);
        int newSize = productDao.getProducts().size();
        assertEquals(originalSize - 1, newSize);

    }
    

}
