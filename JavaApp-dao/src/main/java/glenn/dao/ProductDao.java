package glenn.dao;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import glenn.model.Product;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * @author glenn
 */
public interface ProductDao {

    List<Product> getProducts();

    @Transactional
    void saveProduct(Product p);

    Product get(long i);

    @Transactional
    void delete(Product p);
}
