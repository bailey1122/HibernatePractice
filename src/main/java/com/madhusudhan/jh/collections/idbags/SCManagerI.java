package com.madhusudhan.jh.collections.idbags;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SCManagerI {
    private void  persistIdbags(ShowroomI showroomI) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(showroomI);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void queryIdbags() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("from com.madhusudhan.jh.collections.idbags.ShowroomI").list();
            for (Object object : list) {
                System.out.println("Idbaq items: " + object);
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
        SCManagerI scManagerI = new SCManagerI();
        ShowroomI showroomI = new ShowroomI();
        showroomI.setManager("Barry Larry");
        showroomI.setLocation("East Croydon, Greater London");

        List<CarI> cars = new ArrayList<CarI>();
        cars.add(new CarI("Toyota", "Racing Green"));
        cars.add(new CarI("Toyota", "Racing Green"));
        cars.add(new CarI("Nissan", "White"));
        cars.add(new CarI("BMW", "Black"));
        cars.add(new CarI("Mercedes", "Silver"));

        showroomI.setCars(cars);
        scManagerI.persistIdbags(showroomI);
        scManagerI.queryIdbags();
    }
}
