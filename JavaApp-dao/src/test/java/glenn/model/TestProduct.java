package glenn.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by ycv6026 on 3/5/14.
 */
public class TestProduct {
    @Test
    public void testProductBean() {
        Product p1 = new Product();
        p1.setName("Purina Cat Food");
        p1.setType("Cat Food");
        p1.setCost(5.00);
        p1.setListPrice(10.00);
        assertEquals(p1.getName(),"Purina Cat Food");
        assertEquals(p1.getType(),"Cat Food");
        assertEquals(p1.getCost(),5.00);
        assertEquals(p1.getListPrice(),10.00);

    }
}
