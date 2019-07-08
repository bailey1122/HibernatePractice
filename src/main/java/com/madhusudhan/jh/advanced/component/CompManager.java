package com.madhusudhan.jh.advanced.component;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// components
public class CompManager {
    private void persistComp(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(person);
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
        CompManager compManager = new CompManager();

        // set numbers
        PhoneNumber homNumber = new PhoneNumber(716, 4445366, "NYC"); // a home number
        PhoneNumber mobNumber = new PhoneNumber(323, 486979, "LA"); // a mobile number

        // set people
        Person person = new Person("Katherine", "Kath", "Mag", homNumber, null);
        Person person2 = new Person("John", "Jon", "Redford", null, mobNumber);

        compManager.persistComp(person); // save
        compManager.persistComp(person2);
    }
}
