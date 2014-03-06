package glenn.dao;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import glenn.model.Product;

import java.util.List;

/**
 *
 * @author glenn
 */
public interface ProductDao {

    List<Product> getProducts();

    void saveProduct(Product p);

    Product get(long i);
}
