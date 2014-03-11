/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package glenn.dao;

import com.google.inject.Inject;
import glenn.model.Product;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.transaction.Transaction;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author glenn
 */
public class ProductDaoImpl implements ProductDao {
    private EntityManager entityManager;

    @Inject
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
    @Transactional(Transactional.TxType.MANDATORY)
    public void saveProduct(Product p) {
        entityManager.getTransaction().begin();
        entityManager.persist(p);
        entityManager.getTransaction().commit();
    }

    @Override
    public Product get(long id) {
        Product p = (Product) entityManager.getReference(Product.class,id);
        return p;
    }

    @Override
    @Transactional(Transactional.TxType.MANDATORY)
    public void delete(Product p) {
        entityManager.getTransaction().begin();
        entityManager.remove(p);
        entityManager.getTransaction().commit();
    }

}
