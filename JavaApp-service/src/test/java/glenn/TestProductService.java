package glenn;


import glenn.dao.ProductDao;
import glenn.model.Product;
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
 * Created by ycv6026 on 2/28/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class TestProductService {
    @Mock
    ProductDao productDao;

    @Test
    public void testGetProducts() {
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
        when(productDao.getProducts()).thenReturn(productList);
        ProductService p = new ProductServiceImpl(productDao);
        List<Product> products = p.getProducts();
        verify(productDao).getProducts();
        assertEquals(products.size(),3);

    }
    @Test
    public void testSaveProduct() {
        ProductService productService = new ProductServiceImpl(productDao);
        Product p = new Product();
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        productService.saveProduct(p);
        verify(productDao).saveProduct(p);
    }

    @Test
    public void testGetById() {
        ProductService productService = new ProductServiceImpl(productDao);
        Product p = new Product();
        p.setId(1);
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        when(productDao.get(1)).thenReturn(p);
        Product p1 = productService.get((long)1);
        verify(productDao).get(1);
        assertEquals(p1,p);
    }

    @Test
    public void testDeleteProject() {
        Product p = new Product();
        p.setId(1);
        p.setName("Iams");
        p.setType("Cat Food");
        p.setCost(5.00);
        p.setListPrice(10.00);
        ProductService productService = new ProductServiceImpl(productDao);
        productService.delete(p);
        verify(productDao).delete(p);

    }

}
