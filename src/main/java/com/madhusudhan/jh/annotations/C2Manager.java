package com.madhusudhan.jh.annotations;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class C2Manager {
    private void persistCourse2(Course2 course2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(course2);
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
        C2Manager c2Manager = new C2Manager();
        Course2 course2 = new Course2("Financial Risk Management",
                "Harry Barry");
        course2.setTotalStudents(20);
        course2.setRegisteredStudents(12);
        c2Manager.persistCourse2(course2);
    }
}
