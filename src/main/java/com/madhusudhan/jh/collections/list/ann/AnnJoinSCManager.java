package com.madhusudhan.jh.collections.list.ann;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AnnJoinSCManager {
    private void persistLists(AnnJoinShowroom annJoinShowroom) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(annJoinShowroom);
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
            List list = session.createQuery("from com.madhusudhan.jh.collections.list.ann.AnnJoinShowroom").list();
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
        AnnJoinSCManager annJoinSCManager = new AnnJoinSCManager();
        AnnJoinShowroom annJoinShowroom = new AnnJoinShowroom();
        annJoinShowroom.setManager("Barry Larry");
        annJoinShowroom.setLocation("East Croydon, Greater London");

        Set<AnnJoinCar> cars = new HashSet<AnnJoinCar>();
        cars.add(new AnnJoinCar("Toyota", "Racing Green"));
        cars.add(new AnnJoinCar("Nissan", "White"));
        cars.add(new AnnJoinCar("BMW", "Black"));
        cars.add(new AnnJoinCar("BMW", "Black"));


        annJoinShowroom.setCars(cars);
        annJoinSCManager.persistLists(annJoinShowroom);
        annJoinSCManager.queryLists();
    }
}
