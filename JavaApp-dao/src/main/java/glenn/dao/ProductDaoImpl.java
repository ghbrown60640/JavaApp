/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package glenn.dao;

import glenn.model.Product;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;
import java.util.List;

/**
 * @author glenn
 */
public class ProductDaoImpl implements ProductDao {
    private EntityManager entityManager;

    public ProductDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> getProducts() {
        Query q = entityManager.createQuery("from Product order by id");
        List<Product> productList = (List<Product>) q.getResultList();
        return productList;
    }

    @Override
    public void saveProduct(Product p) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(p);
        transaction.commit();
    }

    @Override
    public Product get(long id) {
        Product p = (Product) entityManager.getReference(Product.class,id);
        return p;
    }

    @Override
    public void delete(Product p) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(p);
        transaction.commit();

    }

}
