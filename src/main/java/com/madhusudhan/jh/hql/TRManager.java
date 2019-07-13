package com.madhusudhan.jh.hql;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TRManager {
    private void persistTR(TravelReview travelReview) { // persist values to the DB
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

    private void findAllTR() { // fetching all rows
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<TravelReview> travelReviews = session.createQuery("from com.madhusudhan.jh.hql.TravelReview").list();
            for (TravelReview tr : travelReviews) { // list all values
                System.out.println("Travel review: " + tr);
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void peginationTR() { // pagination
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview");
            query.setMaxResults(3); // we wanna see only 3 records
            query.setFirstResult(2); // the start position of the result set
            List<TravelReview> reviews = query.list();
            System.out.println("Record limitation: " + reviews);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void findNYSReview() { // retrieving a unique record. Only when there's one record
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview where title='NYC'");
            TravelReview travelReview = (TravelReview) query.uniqueResult(); // get the unique result
            System.out.println(travelReview);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void getReviewWithQueryParam(String city) { // using the placeholder
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview " +
                    "where title=:titleId"); // ':titleId' is the placeholder
            query.setParameter("titleId", city); // set the parameter referring to the city
//            query.setString("titleId", "London");
            TravelReview travelReview = (TravelReview) query.getSingleResult();
            System.out.println("A review with query parameters: " + travelReview);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void usingTheIN() { // finds multiple requests
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List list = new ArrayList(); // define a list and populate with our criteria
            list.add("LA");
            list.add("Las Vegas");
            Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview " +
                    "where title in (:titleList)"); // ':titleList' is the placeholder
            query.setParameter("titleList", list); // set the parameter referring to list
            List<TravelReview> reviews = query.list();
            System.out.println("Multiple requests: " + reviews);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void usingTheINWithParam(String p1, String p2) { // finds multiple requests
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List list = new ArrayList();
            list.add(p1);
            list.add(p2);
            Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview " +
                    "where title in (:titleList)"); // ':titleList' is the placeholder
            query.setParameter("titleList", list); // set the parameter referring to list
            List<TravelReview> reviews = query.list();
            System.out.println("Multiple requests with parameter: " + reviews);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void getReviewWithPosParam() { // using the positional placeholder
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview " +
                    "where title=?1 and id=?2"); // use JPA-style ordinal parameters (e.g., `?1`)
            query.setParameter(1, "Chicago");
            query.setParameter(2, 4);
            TravelReview travelReview = (TravelReview) query.getSingleResult();
            System.out.println("A review with positional parameters: " + travelReview);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void getRequestByAlias() { // using the alias
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview as tr " +
                    "where tr.title=:title and tr.id=:id");
            query.setParameter("title", "NYC");
            query.setParameter("id", 2);
            TravelReview travelReview  = (TravelReview) query.getSingleResult();
            System.out.println(travelReview);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void Iterators() { // using the iterator
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from com.madhusudhan.jh.hql.TravelReview");
            Iterator iterator = query.list().iterator();
            while(iterator.hasNext()) {
                TravelReview travelReview = (TravelReview) iterator.next();
                System.out.println("Travel review by iterator: " + travelReview);
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void Selects() { // using the select operator
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT tr.review from com.madhusudhan.jh.hql.TravelReview as tr");
            //  each review is a long description in String format
            List<String> reviews = query.list();

            System.out.println("City Review: ");
            for (String rw : reviews) {
                System.out.println("\t" + rw); // slide to the right by '\t'
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void getTRWithSelectTuples() { // using the select operator when we're selecting multiple columns
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("SELECT tr.title, tr.review from com.madhusudhan.jh.hql.TravelReview tr");
            Iterator iterator = query.list().iterator();
            while (iterator.hasNext()) {
                Object[] r = (Object[]) iterator.next();
                System.out.println("Title: " + r[0] + "\t");
                System.out.println("Review: " + r[1]);
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void getTRWithSelectADomainObject() { // turning the results into a domain object
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String QUERY = "SELECT new com.madhusudhan.jh.hql.City(rw.title, rw.review) " +
                    "from com.madhusudhan.jh.hql.TravelReview rw";
            List<City> cities = session.createQuery(QUERY).list();
            for (City city : cities) {
                System.out.println("City: " + city);
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

//    Aggregate Functions
//    List review = session.createQuery("SELECT max(ticket_price) from TravelFlight").list();
//    List review2 = session.createQuery("SELECT avg(planet_age) from Galaxy").list();

    private void updateAndChange() { // change and update
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("update com.madhusudhan.jh.hql.TravelReview " +
                    "set review=:review where id=:id");
            query.setParameter("review", "A new review");
            query.setParameter("id", 3); // change LA Review
            int success = query.executeUpdate(); // execute and update the statement
            System.out.println("Success: " + success);
            // get the updated review
            Query selectNewReview = session.createQuery("from com.madhusudhan.jh.hql.TravelReview where id = 3");
            TravelReview review = (TravelReview) selectNewReview.getSingleResult();
            System.out.println(review);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void deleteAndUpdate() { // delete and update
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("delete from com.madhusudhan.jh.hql.TravelReview where id = 2");
            int success = query.executeUpdate(); // execute and then update the statement
            System.out.println("Success: " + success);

            List<TravelReview> reviews = session.createQuery("from com.madhusudhan.jh.hql.TravelReview").list();
            for (TravelReview tr : reviews) {
                System.out.println("The updated result: " + tr);
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void criteria() { // using the criteria
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            CriteriaBuilder builder = session.getCriteriaBuilder(); // create a CriteriaBuilder() instance
            CriteriaQuery<TravelReview> criteria = builder.createQuery(TravelReview.class); // create a query object
            Root<TravelReview> root = criteria.from(TravelReview.class); // define a range variable in FROM clause
            criteria.select(root).where(builder.like(root.<String>get("title"), "London")); // specify type of the query
            Query<TravelReview> query = session.createQuery(criteria); // prepare the query for execution
            List<TravelReview> list = query.getResultList(); // execute it
            for (TravelReview review : list) { // get a list
                System.out.println("Criteria: " + review);
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    private void usingNamedQuery() { // using named queries
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            System.out.println("GET_TRAVEL_REVIEWS");
            Query query = session.getNamedQuery("GET_TRAVEL_REVIEWS");
            List reviews = query.list();
            for (Object r : reviews) {
                System.out.println("TR: " + r.toString());
            }

            System.out.println("GET_TRAVEL_REVIEWS_FOR_TITLE");
            Query query2 = session.getNamedQuery("GET_TRAVEL_REVIEWS_FOR_TITLE");
            query2.setParameter("title", "Chicago");
            List rw = query2.list();
            for (Object r : rw) {
                System.out.println("TR: " + r.toString());
            }
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        }
    }

    public static void main(String[] args) {
        TRManager trManager = new TRManager();

        TravelReview travelReview = new TravelReview("The London Review of Books", "London");
        TravelReview travelReview2 = new TravelReview("The New York Review of Books", "NYC");
        TravelReview travelReview3 = new TravelReview("The Los Angeles Review of Books", "LA");
        TravelReview travelReview4 = new TravelReview("Chicago Review", "Chicago");
        TravelReview travelReview5 = new TravelReview("The Paris Review", "Paris");
        TravelReview travelReview6 = new TravelReview("The Las Vegas Review", "Las Vegas");

        trManager.persistTR(travelReview);
        trManager.persistTR(travelReview2);
        trManager.persistTR(travelReview3);
        trManager.persistTR(travelReview4);
        trManager.persistTR(travelReview5);
        trManager.persistTR(travelReview6);

//        trManager.findAllTR();
//        trManager.peginationTR();
//        trManager.findNYSReview();
//        trManager.getReviewWithQueryParam("Paris");
//        trManager.usingTheIN();
//        trManager.usingTheINWithParam("LA", "Las Vegas");
//        trManager.getReviewWithPosParam();
//        trManager.getRequestByAlias();
//        trManager.Iterators();
//        trManager.Selects();
//        trManager.getTRWithSelectTuples();
//        trManager.getTRWithSelectADomainObject();
//        trManager.updateAndChange();
//        trManager.deleteAndUpdate();
//        trManager.criteria();
        trManager.usingNamedQuery();
    }
}
