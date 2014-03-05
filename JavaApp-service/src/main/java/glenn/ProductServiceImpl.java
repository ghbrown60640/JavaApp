/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glenn;

import glenn.dao.ProductDao;
import glenn.model.Product;

import java.util.List;

/**
 *
 * @author glenn
 */
class ProductServiceImpl implements ProductService {

    private ProductDao productDao;



    public ProductServiceImpl(ProductDao productDao) {
        this.productDao=productDao;
    }

    public List<Product> getProducts() {
        return productDao.getProducts();
    }



}
