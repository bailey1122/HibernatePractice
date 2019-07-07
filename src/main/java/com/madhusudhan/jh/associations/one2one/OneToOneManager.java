package com.madhusudhan.jh.associations.one2one;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToOneManager {
    private void persistOneToOne(Car121 car121, Engine121 engine121) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(car121);
            session.save(engine121);
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
        OneToOneManager oneToOneManager = new OneToOneManager();
        Car121 car121 = new Car121();
        Engine121 engine121 = new Engine121();

//        car121.setId(1);
        car121.setName("Cadillac ATS Sedan");
        car121.setColor("White");

        engine121.setMake("V8 Series");
        engine121.setModel("DTS");
        engine121.setSize("1.6 V8 GAS");

        car121.setEngine121(engine121);
        engine121.setCar121(car121);

        oneToOneManager.persistOneToOne(car121, engine121);
    }
}
