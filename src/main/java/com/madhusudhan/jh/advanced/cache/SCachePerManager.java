package com.madhusudhan.jh.advanced.cache;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// the second level caching
public class SCachePerManager {
    private void secondLevelCache() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            Integer person_id = 1;
            tx = session.beginTransaction();
            SCachePerson sCachePerson = session.get(SCachePerson.class, person_id); // add this object to the second
            System.out.println(sCachePerson); // level cache
            System.out.println("-------------------------------");
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            throw ex;
        } finally {
            session.close(); // the object is still in the second level cache
        }

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        tx = null;
        try {
            Integer person_id = 1;
            tx = session1.beginTransaction();
            SCachePerson sCachePerson = session1.get(SCachePerson.class, person_id); // use the object from cache
            System.out.println(sCachePerson); // we can't see second select statement 'cause we're using cache
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session1.close();
        }
    }

    public static void main(String[] args) {
        SCachePerManager sCachePerManager = new SCachePerManager();
        sCachePerManager.secondLevelCache();
    }
}
