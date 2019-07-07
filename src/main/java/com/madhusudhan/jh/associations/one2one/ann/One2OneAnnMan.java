package com.madhusudhan.jh.associations.one2one.ann;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// one to one mapping with foreign key association
public class One2OneAnnMan {
    private void persistOneTwoOne(CarAnn121 carAnn121, EngineAnn121 engineAnn121) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(carAnn121);
            session.save(engineAnn121);
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
        One2OneAnnMan one2OneAnnMan = new One2OneAnnMan();
        CarAnn121 carAnn121 = new CarAnn121();
        EngineAnn121 engineAnn121 = new EngineAnn121();

        carAnn121.setId(1);
        carAnn121.setName("Cadillac ATS Sedan");
        carAnn121.setColor("White");

        engineAnn121.setMake("V8Series");
        engineAnn121.setModel("DTS");
        engineAnn121.setSize("1.6 V8 GAS");

        carAnn121.setEngineAnn121(engineAnn121);
        engineAnn121.setCarAnn121(carAnn121);

        one2OneAnnMan.persistOneTwoOne(carAnn121, engineAnn121);
    }
}
