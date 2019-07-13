package com.madhusudhan.jh.hql;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

// using named queries
public class TRNManager {
    private void persistTRN(TRNamedQueries travelReview) { // persist values to the DB
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(travelReview);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void usingNamedQuery2() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            System.out.println("MAP_GET_TRAVEL_REVIEWS");
            Query query = session.getNamedQuery("com.madhusudhan.jh.hql.TRNamedQueries.MAP_GET_TRAVEL_REVIEWS");
            List reviews = query.list();
            for (Object r : reviews) {
                System.out.println(r.toString());
            }

            System.out.println("MAP_GET_TRAVEL_REVIEWS_FOR_TITLE");
            Query query2 = session.getNamedQuery("com.madhusudhan.jh.hql.TRNamedQueries.MAP_GET_TRAVEL_REVIEWS_FOR_TITLE");
            query2.setParameter("review", "NYC");
            List rw = query2.list();
            for (Object r : rw) {
                System.out.println(r.toString());
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    public static void main(String[] args) {
        TRNManager trnmManager = new TRNManager();
        TRNamedQueries travelReview = new TRNamedQueries("The London Review of Books", "London");
        TRNamedQueries travelReview2 = new TRNamedQueries("The New York Review of Books", "NYC");
        TRNamedQueries travelReview3 = new TRNamedQueries("The Los Angeles Review of Books", "LA");
        TRNamedQueries travelReview4 = new TRNamedQueries("Chicago Review", "Chicago");

        trnmManager.persistTRN(travelReview);
        trnmManager.persistTRN(travelReview2);
        trnmManager.persistTRN(travelReview3);
        trnmManager.persistTRN(travelReview4);

        trnmManager.usingNamedQuery2();
    }
}
