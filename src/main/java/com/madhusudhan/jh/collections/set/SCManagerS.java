package com.madhusudhan.jh.collections.set;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SCManagerS {
    private void persistSets(ShowroomS showroomS) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(showroomS);
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void querySets() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("from com.madhusudhan.jh.collections.set.ShowroomS").list();
            for (Object object : list) {
                System.out.println("Set items: " + object);
            }
            tx.commit();
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }


    public static void main(String[] args) {
        // Create and populate showroomS
        SCManagerS scManager = new SCManagerS();
        ShowroomS showroomS = new ShowroomS();
        showroomS.setManager("Barry Larry");
        showroomS.setLocation("East London, Greater London");

        // Create and populate cars set
        Set<CarS> cars = new HashSet<CarS>();
        cars.add(new CarS("Toyota", "Racing Green"));
        cars.add(new CarS("Nissan", "White"));
        cars.add(new CarS("BMW", "Black"));
        cars.add(new CarS("BMW", "Black"));


        // Associate cars to the showroomS and persist it
        showroomS.setCars(cars);
        scManager.persistSets(showroomS);
        scManager.querySets();
    }
}
