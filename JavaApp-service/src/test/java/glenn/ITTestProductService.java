package glenn;


import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import glenn.dao.ProductDao;
import glenn.dao.ProductDaoImpl;
import glenn.model.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;



/**
 * Created by ycv6026 on 2/28/14.
 */

public class ITTestProductService {

    Injector injector;
    ProductService productService;

    @Before
    public void setUp() {
        injector = Guice.createInjector(new JpaPersistModule("hsqldb-ds"), new AbstractModule() {
            @Override
            protected void configure() {

                bind(ProductService.class).to(ProductServiceImpl.class);
                bind(ProductDao.class).to(ProductDaoImpl.class);

            }
        });
        injector.getInstance(PersistService.class).start();
        productService = injector.getInstance(ProductService.class);
    }

    @After
    public void tearDown(){
        injector.getInstance(PersistService.class).stop();
    }
    @Test
    public void testGetProducts() {
        List<Product> productList = new ArrayList<Product>();
        Product p1 = new Product();
        p1.setName("Purina Cat Food");
        p1.setType("Cat Food");
        p1.setCost(5.00);
        p1.setListPrice(10.00);
        productService.saveProduct(p1);
        productList.add(p1);
        Product p2 = new Product();
        p2.setName("Purina Dog Food");
        p2.setType("Dog Food");
        p2.setCost(5.00);
        p2.setListPrice(10.00);
        productService.saveProduct(p2);
        productList.add(p2);
        Product p3 = new Product();
        p3.setName("Catnip Mouse");
        p3.setType("Cat Toy");
        p3.setCost(1.00);
        p3.setListPrice(2.00);
        productService.saveProduct(p3);
        productList.add(p3);


        List<Product> products = productService.getProducts();
        assertEquals(products.size(),3);

    }

    public void testSaveProduct() {
        Product p = new Product();
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        productService.saveProduct(p);
    }

    @Test
    public void testGetById() {
        Product p = new Product();
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        productService.saveProduct(p);
        Product p1 = productService.get(p.getId());
        assertEquals(p1, p); 
    }

    @Test
    public void testDeleteProject() {
        Product p = new Product();
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        productService.saveProduct(p);
        assertEquals(productService.getProducts().size(),1);
        productService.delete(p);
        assertEquals(productService.getProducts().size(),0);
    }

}
