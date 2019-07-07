package com.madhusudhan.jh.associations.one2one.ann;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// one to one mapping with common join table
public class One2OneJAnnMan {
    private void persistOne2One(CarJAnn121 carJAnn121) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(carJAnn121);
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
        One2OneJAnnMan one2OneJAnnMan = new One2OneJAnnMan();
        CarJAnn121 carJAnn121 = new CarJAnn121();
        EngineJAnn121 engineJAnn121 = new EngineJAnn121();

        carJAnn121.setId(2);
        carJAnn121.setName("Cadillac ATS Sedan");
        carJAnn121.setColor("White");

        engineJAnn121.setMake("V8 Series");
        engineJAnn121.setModel("DTS");
        engineJAnn121.setSize("1.6 V8 GAS");

        carJAnn121.setEngineJAnn121(engineJAnn121);

        one2OneJAnnMan.persistOne2One(carJAnn121);
    }
}
