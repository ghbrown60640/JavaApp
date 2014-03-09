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
import javax.transaction.Transaction;
import java.util.List;

/**
 *
 * @author glenn
 */
public class ProductDaoImpl implements ProductDao {
    private EntityManager entityManager;

    public ProductDaoImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }




    @Override
    public List<Product> getProducts() {


        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query q =  entityManager.createQuery("from Product order by id");
        List<Product> productList = (List<Product>) q.list();
        transaction.commit();


        return productList;

    }

    @Override
    public void saveProduct(Product p) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(p);
        transaction.commit();
    }

    @Override
    public Product get(long i) {

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Product p = (Product) session.get(Product.class,i);
        transaction.commit();
        return p;
    }

    @Override
    public void delete(Product p) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.delete(p);
        transaction.commit();

    }

}
