package com.madhusudhan.jh.collections.map;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SCManagerM {
    private void persistMaps(ShowroomM showroomM) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(showroomM);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void queryMaps() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List list = session.createQuery("from com.madhusudhan.jh.collections.map.ShowroomM").list();
            for (Object object : list) {
                System.out.println("Map items: " + object);
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
        SCManagerM scManagerM = new SCManagerM();
        ShowroomM showroomM = new ShowroomM();
        showroomM.setManager("Cherry Flurry");
        showroomM.setLocation("East Croydon");

        Map<String, CarM> cars = new HashMap<String, CarM>();
        cars.put("barry", new CarM("Toyota", "Racing Green"));
        cars.put("larry", new CarM("Nissan", "White"));
        cars.put("harry", new CarM("BMW", "Black"));
        showroomM.setCars(cars);
        scManagerM.persistMaps(showroomM);
        scManagerM.queryMaps();
    }
}
