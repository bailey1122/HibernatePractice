package com.madhusudhan.jh.associations.one2many.bi;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class AOne2ManyBManager {
    private void persistA12m(AMovieB12m aMovieB12m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(aMovieB12m);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void find(AActorB12m aActorB12m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            System.out.println(aActorB12m.getaMovieB12mS());
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
        AOne2ManyBManager aOne2ManyBManager = new AOne2ManyBManager();
        AMovieB12m movie = new AMovieB12m("Interstellar");

        AActorB12m factor = new AActorB12m("Matthew", "McConaughey", "Cooper");
        AActorB12m sactor = new AActorB12m("Mackenzie", "Foy", "Murph");

        Set<AActorB12m> aActorB12ms = new HashSet<AActorB12m>();
        aActorB12ms.add(factor);
        factor.setaMovieB12mS(movie);
        aActorB12ms.add(sactor);
        sactor.setaMovieB12mS(movie);

        movie.setaActorB12ms(aActorB12ms);
        aOne2ManyBManager.persistA12m(movie);

        System.out.println("Matthew McCo...: ");
        aOne2ManyBManager.find(factor);
        System.out.println("Mackenzie F...: ");
        aOne2ManyBManager.find(sactor);
    }
}
