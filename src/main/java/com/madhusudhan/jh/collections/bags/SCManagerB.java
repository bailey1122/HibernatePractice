package com.madhusudhan.jh.collections.bags;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SCManagerB {
    private void persistBags(ShowroomB showroomB) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(showroomB);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void queryBags() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("from com.madhusudhan.jh.collections.bags.ShowroomB").list();
            for (Object object : list) {
                System.out.println("Bag items: " + object);
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.commit();
            throw ex;
        } finally {
            session.close();
        }
    }

    public static void main(String[] args) {
        SCManagerB scManagerB = new SCManagerB();
        ShowroomB showroomB = new ShowroomB();
        showroomB.setManager("Barry Larry");
        showroomB.setLocation("East Croydon, Greater London");

        List<CarB> cars = new ArrayList<CarB>();
        cars.add(new CarB("Toyota", "Racing Green"));
        cars.add(new CarB("Toyota", "Racing Green"));
        cars.add(new CarB("Nissan", "White"));
        cars.add(new CarB("BMW", "Black"));
        cars.add(new CarB("Mercedes", "Silver"));

        showroomB.setCars(cars);
        scManagerB.persistBags(showroomB);
        scManagerB.queryBags();
    }
}
