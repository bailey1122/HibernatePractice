package com.madhusudhan.jh.associations.one2many;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class AOne2mManager {
    private void persistA12m(AMovie12m aMovie12m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(aMovie12m);
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
        AOne2mManager aOne2mManager = new AOne2mManager();
        AMovie12m movie = new AMovie12m("Interstellar");

        AActor12m actor = new AActor12m("Matthew", "McConaughey", "Cooper");
        AActor12m actor2 = new AActor12m("Mackenzie", "Foy", "Murph");

        Set<AActor12m> aaActor12ms = new HashSet<AActor12m>();
        aaActor12ms.add(actor);
        aaActor12ms.add(actor2);

        movie.setAaActor12ms(aaActor12ms);
        aOne2mManager.persistA12m(movie);
    }
}
