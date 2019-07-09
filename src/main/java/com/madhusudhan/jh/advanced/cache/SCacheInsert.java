package com.madhusudhan.jh.advanced.cache;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// the second level caching
public class SCacheInsert {
    private void persistSCache(SCachePerson sCachePerson) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(sCachePerson);
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
        SCacheInsert sCacheInsert = new SCacheInsert();

        SCachePerson sCachePerson = new SCachePerson();
        sCachePerson.setFname("Mark");
        sCachePerson.setLname("Craig");
        sCachePerson.setNname("Fig");

        SCachePerson sCachePerson2 = new SCachePerson();
        sCachePerson2.setFname("Dan");
        sCachePerson2.setLname("Brook");
        sCachePerson2.setNname("Danny");

        sCacheInsert.persistSCache(sCachePerson);
        sCacheInsert.persistSCache(sCachePerson2);
    }
}
