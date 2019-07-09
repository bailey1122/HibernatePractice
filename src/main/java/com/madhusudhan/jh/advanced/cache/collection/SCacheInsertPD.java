package com.madhusudhan.jh.advanced.cache.collection;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// the second level caching and a collection
public class SCacheInsertPD {
    private void persistSCache(SCacheCDep sCacheCDep) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(sCacheCDep);
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
        // insert values into DB
        SCacheInsertPD sCacheInsertPD = new SCacheInsertPD();

        SCacheCPerson person1 = new SCacheCPerson("Daniel", "Berian", 40);
        SCacheCPerson person2 = new SCacheCPerson("Sarah", "Loor", 25);

        SCacheCDep sCacheCDep = new SCacheCDep("Department store");
        sCacheCDep.getsCacheCPersons().add(person1);
        sCacheCDep.getsCacheCPersons().add(person2);

        person1.setsSCacheCDeps(sCacheCDep);
        person2.setsSCacheCDeps(sCacheCDep);

        sCacheInsertPD.persistSCache(sCacheCDep);
    }
}
