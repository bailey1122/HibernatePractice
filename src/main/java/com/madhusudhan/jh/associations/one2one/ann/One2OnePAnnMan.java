package com.madhusudhan.jh.associations.one2one.ann;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// hibernate one to one mapping with shared primary key
public class One2OnePAnnMan {
    private void persistOne2One(CarPAnn121 carPAnn121, EnginePAnn121 enginePAnn121) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(carPAnn121);
            session.save(enginePAnn121);
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
        One2OnePAnnMan one2OnePAnnMan = new One2OnePAnnMan();
        CarPAnn121 carPAnn121 = new CarPAnn121();
        EnginePAnn121 enginePAnn121 = new EnginePAnn121();

        carPAnn121.setId(1);
        carPAnn121.setName("Cadillac ATS Sedan");
        carPAnn121.setColor("White");

        enginePAnn121.setMake("V8 Series");
        enginePAnn121.setModel("DTS");
        enginePAnn121.setSize("1.6 V8 GAS");

        carPAnn121.setEnginePAnn121(enginePAnn121);
        enginePAnn121.setCarPAnn121(carPAnn121);

        one2OnePAnnMan.persistOne2One(carPAnn121, enginePAnn121);

    }
}
