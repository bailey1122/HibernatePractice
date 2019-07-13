package com.madhusudhan.jh.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// JPA
public class InstrumentManager {
    private void persistInstr(Instrument instrument) { // persist values to the DB
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("trading_entities");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(instrument);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    // getReference() fetches a lazy-loaded entity. The attributes of the class, apart from
    // its pk, aren't fetched. Throws an EntityNotFoundException if there's no record in the DB
    private void findGetRef() {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("trading_entities");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("getReference(): ");
        Instrument instrument = em.getReference(Instrument.class, 1);
        System.out.println(instrument);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private void find() { // opposite to getReference()
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("trading_entities");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        System.out.println("find(): ");
        Instrument instrument = em.find(Instrument.class, 1);
        System.out.println(instrument);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private void deleteInstr() { // the remove method
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("trading_entities");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Instrument instrument = em.find(Instrument.class, 1);
        em.remove(instrument); // delete
        System.out.println("Deleted successfully");

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public static void main(String[] args) {
        InstrumentManager instrumentManager = new InstrumentManager();
        Instrument instrument = new Instrument(1,"Maven", "Work"); // an example

        instrumentManager.persistInstr(instrument);
        instrumentManager.findGetRef();
        instrumentManager.find();
        instrumentManager.deleteInstr();
    }
}
