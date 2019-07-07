package com.madhusudhan.jh.associations.one2one;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToOne2Manager {
    private void persistOneToOne(Car_2_121 car_2_121) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(car_2_121);
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
        OneToOne2Manager oneToOne2Manager = new OneToOne2Manager();
        Car_2_121 car = new Car_2_121();
        Engine_2_121 engine = new Engine_2_121();
//        car.setId(1);
        car.setName("Cadillac ATS Sedan");
        car.setColor("White");

//        engine.setId(1);
        engine.setSize("1.6 V8 GAS");
        engine.setModel("DTS");
        engine.setMake("V8 Series");
        engine.setSize("1.6 V8 GAS");


        car.setEngine_2_121(engine);
        oneToOne2Manager.persistOneToOne(car);
    }
}
