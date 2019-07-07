package com.madhusudhan.jh.collections.array;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SCManagerA {
    private void persistArrays(ShowroomA showroomA) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(showroomA);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void queryArrays() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("from com.madhusudhan.jh.collections.array.ShowroomA").list();
            for (Object object : list) {
                System.out.println("Array items: " + object);
            }
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
        SCManagerA scManagerA = new SCManagerA();
        ShowroomA showroomA = new ShowroomA();
        showroomA.setManager("Barry Larry");
        showroomA.setLocation("East Croydon, Greater London");

        String[] cars = new String[]{"Toyota", "BMW", "Citroen"};
        showroomA.setCars(cars);
        scManagerA.persistArrays(showroomA);
        scManagerA.queryArrays();
    }
}
