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

    @Override
    public void saveProduct(Product p) {
        productDao.saveProduct(p);
    }

    @Override
    public Product get(long i) {
        return productDao.get(i);
    }

    @Override
    public void delete(Product p) {
        productDao.delete(p);
    }


}
