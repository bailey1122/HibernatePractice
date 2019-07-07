package com.madhusudhan.jh.associations.many2many;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

// never use a List in many2many
public class BM2mManager {
    private void persistM2mC(BM2mCourse bM2MCourse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(bM2MCourse);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void persistM2mS(BM2mStudent bM2MStudent) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(bM2MStudent);
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
        BM2mManager bM2MManager = new BM2mManager();

        // if you wanna persist the same values (student and bM2MStudent2), it won't show
        // the right way 'cause you're using a SET. Duplicates aren't
        // allowed in a SET. By the way, it represents unordered data structure.
        // So, used different values to show associations more clearly
        BM2mStudent bM2MStudent = new BM2mStudent("Sarah"); // set a Student
        BM2mStudent bM2MStudent2 = new BM2mStudent("James");
        BM2mStudent bM2MStudent3 = new BM2mStudent("Maggy");

        BM2mCourse bM2MCourse = new BM2mCourse("Math"); // set a subject
        BM2mCourse bM2MCourse2 = new BM2mCourse("Physics");
        BM2mCourse bM2MCourse3 = new BM2mCourse("Philosophy");
        BM2mCourse bM2MCourse4 = new BM2mCourse("Computer Science");

        Set<BM2mCourse> bM2MCourses = new HashSet<BM2mCourse>(); // a Course set
        bM2MCourses.add(bM2MCourse2);
        bM2MCourses.add(bM2MCourse3);
        bM2MCourses.add(bM2MCourse4);

        bM2MStudent3.setbM2MCourses(bM2MCourses);
        bM2MManager.persistM2mS(bM2MStudent3);

        Set<BM2mStudent> bM2MStudents = new HashSet<BM2mStudent>();
        bM2MStudents.add(bM2MStudent);
        bM2MStudents.add(bM2MStudent2);

        bM2MCourse.setbM2MStudents(bM2MStudents);
        bM2MManager.persistM2mC(bM2MCourse);
    }
}
