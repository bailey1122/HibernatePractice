package com.madhusudhan.jh.advanced.filters;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

// an example of how filters work
public class FCarManager {
    private void persistFCar(FCar fCar) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(fCar);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void filterFCar() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Filter filter = session.enableFilter("filterByMake");
            filter.setParameter("make", "Germany");
            List results = session.createQuery("from FCar").list();
            System.out.println(results);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        FCarManager fCarManager = new FCarManager();

        FCar car = new FCar("Black", "Porsche", "China", "Cayenne");
        FCar car2 = new FCar("Red", "BMW", "Germany", "X7");
        FCar car3 = new FCar("White", "Mercedes", "USA", "S-Class");

        fCarManager.persistFCar(car);
        fCarManager.persistFCar(car2);
        fCarManager.persistFCar(car3);

        fCarManager.filterFCar();
    }
}
