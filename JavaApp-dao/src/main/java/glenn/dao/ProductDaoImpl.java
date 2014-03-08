/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package glenn.dao;

import glenn.model.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.List;

/**
 *
 * @author glenn
 */
public class ProductDaoImpl implements ProductDao {
    private SessionFactory sessionFactory;

    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }




    @Override
    public List<Product> getProducts() {

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query q =  session.createQuery("from Product order by id");
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
