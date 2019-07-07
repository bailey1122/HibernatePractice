package com.madhusudhan.jh.associations.one2many.bi;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class One2ManyBManager {
    private void persistOneTwoMany(MovieB12m m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(m);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
                throw ex;
        } finally {
            session.close();
        }
    }

    private void find(ActorB12m actorB12m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            System.out.println(actorB12m.getMovieB12mS());
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
        One2ManyBManager one2ManyBManager = new One2ManyBManager();
        MovieB12m movie = new MovieB12m("Interstellar");

        ActorB12m factor = new ActorB12m("Matthew", "McConaughey", "Cooper");
        ActorB12m sactor = new ActorB12m("Mackenzie", "Foy", "Murph");

        // we have bidirectional relationship, this means we need to assign object to each side of the
        // relationship
        Set<ActorB12m> actorB12ms = new HashSet<ActorB12m>();
        actorB12ms.add(factor);
        factor.setMovieB12mS(movie); // populate an movie
        actorB12ms.add(sactor);
        sactor.setMovieB12mS(movie); // populate an movie

        movie.setActorB12ms(actorB12ms); // populate an actor
        one2ManyBManager.persistOneTwoMany(movie);

        System.out.println("Matthew McCo...: ");
        one2ManyBManager.find(factor); // find the movie in which an actor appeared
        System.out.println("Mackenzie F...: ");
        one2ManyBManager.find(sactor);
    }
}
