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
        Query q = session.createQuery("select p from Product order by id");
        return q.list();

    }

    @Override
    public void saveProduct(Product p) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(p);
    }

    @Override
    public Product get(long i) {
        Session session = sessionFactory.getCurrentSession();
        return (Product) session.get(Product.class,i);
    }

}
