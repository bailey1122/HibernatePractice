package com.madhusudhan.jh.advanced.cache;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// the first level caching, which available during the lifespan of that session
// or in the conversations only. This caching is provided by default by the framework
public class CashPerManager {
    private void firstLevelCache() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            CashPerson cashPerson = new CashPerson();
            cashPerson.setFirstName("Patrick");
            cashPerson.setLastName("Feg");

            tx = session.beginTransaction();
            Integer personId = (Integer) session.save(cashPerson); // getting the return of pk
            tx.commit();

            tx = session.beginTransaction();
            // loading the same object to set the nickname. We're using the same session
            cashPerson = (CashPerson) session.load(CashPerson.class, personId);
            cashPerson.setNickName("Aman");
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
        CashPerManager cashPerManager = new CashPerManager();
        cashPerManager.firstLevelCache();
    }
}
