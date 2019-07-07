package com.madhusudhan.jh.associations.one2many;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class OneToManyManager {
    private void persistOneTwoMany(Movie12m movie12m) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
           tx = session.beginTransaction();
           session.save(movie12m);
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
        OneToManyManager oneToManyManager = new OneToManyManager();
        Movie12m movie12m = new Movie12m("Interstellar");

        Set<Actor12m> actor12ms = new HashSet<Actor12m>();
        actor12ms.add(new Actor12m("Matthew", "McConaughey", "Cooper"));
        actor12ms.add(new Actor12m("Mackenzie", "Foy", "Murph"));

        movie12m.setActor12ms(actor12ms);
        oneToManyManager.persistOneTwoMany(movie12m);
    }
}
