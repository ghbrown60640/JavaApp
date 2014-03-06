/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package glenn;


import glenn.model.Product;
import java.util.List;

/**
 *
 * @author glenn
 */
public interface ProductService {
    public List<Product> getProducts();
    public void saveProduct(Product p);

    Product get(long i);
}
