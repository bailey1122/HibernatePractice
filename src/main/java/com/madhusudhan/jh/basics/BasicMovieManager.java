package com.madhusudhan.jh.basics;

import com.madhusudhan.jh.HibernateUtil;
import com.madhusudhan.jh.domain.Movie;
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BasicMovieManager {
    private void persistMovie(Movie movie) {
        // create Session via SessionFactory
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction(); // create a Transaction instance
            session.save(movie);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback(); // if something's going bad
            throw ex;
        } finally {
            session.close(); //close
        }
    }

    private void findMovie(int movieId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Movie movie = (Movie) session.load(Movie.class, movieId);
            System.out.println("Movie12m: " + movie.getTitle() + ", '" +
                    movie.getSynopsis() + "', " + movie.getDirector());
//            List<Movie12m> mov = session.createQuery("from com.madhusudhan.jh.domain.Movie12m").list();
//            System.out.println(mov); // get all movies
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
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            session.beginTransaction();
//            Movie12m movie = new Movie12m();
//            movie.setId(1);
//            movie.setTitle("Jaws");
//            movie.setDirector("Steven Spielberg");
//            movie.setSynopsis("Story of a shark!");
//
//            session.save(movie);
//            session.getTransaction().commit();
//            session.close();
//        } catch (Exception ex) {
//            System.err.println(ex);
//        }

        BasicMovieManager basicMovieManager = new BasicMovieManager();
        Movie movie = new Movie();
        movie.setId(1);
        movie.setTitle("Jaws");
        movie.setDirector("Steven Spielberg");
        movie.setSynopsis("Story of a shark!");

        basicMovieManager.persistMovie(movie);
        basicMovieManager.findMovie(1);

    }
}
