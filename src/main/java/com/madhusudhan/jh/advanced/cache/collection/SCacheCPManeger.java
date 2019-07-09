package com.madhusudhan.jh.advanced.cache.collection;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

// the second level caching and a collection
public class SCacheCPManeger {
    private void secondLevelCache() {
        String SELECT_S_CACHE_COLL_PERSON_HQL = "FROM SCacheCPerson"; // create a query
        Session session = null;
        try {
            // hibernate hits data from DB at first time
            System.out.println("getting person list from DB..");
            session = HibernateUtil.getSessionFactory().openSession();

            // set .setCacheable(true) to get the query by cache
            @SuppressWarnings("unchecked") // suppress a list of multiple warnings
            List<SCacheCPerson> persons = session.createQuery(SELECT_S_CACHE_COLL_PERSON_HQL).setCacheable(true)
                    .setCacheRegion("s_cache_coll_person.cache").list();
            for (SCacheCPerson p : persons) { // get values
                System.out.println("Person's name: " + p.getFname());
                System.out.println("Person's last name: " + p.getLname());
                System.out.println("Person's age: " + p.getAge());
                System.out.println("Person's department: " + p.getsSCacheCDeps());

                System.out.println("---------------------------------------");
            }
        } catch (HibernateException ex) {
            throw ex;
        } finally {
            if (session != null)
            session.close();
        }

        Session session2 = HibernateUtil.getSessionFactory().openSession();
        try {
            // hibernate gets data from cache not DB
            System.out.println("getting person list from cache..");
            session2 = HibernateUtil.getSessionFactory().openSession();

            // set .setCacheable(true) to get the query by cache
            @SuppressWarnings("unchecked") // suppress a list of multiple warnings
            List<SCacheCPerson> persons = session2.createQuery(SELECT_S_CACHE_COLL_PERSON_HQL).setCacheable(true)
                    .setCacheRegion("s_cache_coll_person.cache").list();
            for (SCacheCPerson p : persons) { // get values
                System.out.println("Person's name: " + p.getFname());
                System.out.println("Person's last name: " + p.getLname());
                System.out.println("Person's age: " + p.getAge());
                System.out.println("Person's department: " + p.getsSCacheCDeps());

                System.out.println("---------------------------------------");
            }
        } catch (HibernateException ex) {
            throw ex;
        } finally {
            if (session2 != null)
                session2.close();
        }
    }

    public static void main(String[] args) {
        SCacheCPManeger sCacheCPManeger = new SCacheCPManeger();
        sCacheCPManeger.secondLevelCache();
    }
}
