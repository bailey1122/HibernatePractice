package com.madhusudhan.jh.collections.list.ann;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AnnSCManager {
    private void persistLists(AnnShowroom annShowroom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(annShowroom);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void queryLists() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("from com.madhusudhan.jh.collections.list.ann.AnnShowroom").list();
            for (Object object : list) {
                System.out.println("List items: " + object);
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
        AnnSCManager annSCManager = new AnnSCManager();
        AnnShowroom annShowroom = new AnnShowroom();
        annShowroom.setManager("Barry Larry");
        annShowroom.setLocation("East Croydon, Greater London");

        List<AnnCar> cars = new ArrayList<AnnCar>();
        cars.add(new AnnCar("Toyota", "Racing Green"));
        cars.add(new AnnCar("Toyota", "Racing Green"));
        cars.add(new AnnCar("Nissan", "White"));
        cars.add(new AnnCar("BMW", "Black"));
        cars.add(new AnnCar("Mercedes", "Silver"));

        annShowroom.setCars(cars);
        annSCManager.persistLists(annShowroom);
        annSCManager.queryLists();
    }
}
