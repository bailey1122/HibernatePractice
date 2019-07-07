package com.madhusudhan.jh.associations.many2many.ann;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

// never use a List in many2many
public class ABM2mManager {
    private void persistAM2mC(ABM2mCourse aBM2MCourse) { // persist a Course
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(aBM2MCourse); // ABM2MCourse
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void persistAM2mS(ABM2mStudent aBM2mStudent) { // persist a BM2mStudent
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(aBM2mStudent); // am2mCourse
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
        ABM2mManager aBM2MManager = new ABM2mManager();

        // create students
        // if you wanna persist the same values (student and m2mStudent2), it won't show
        // the right way 'cause you're using a SET. Duplicates aren't
        // allowed in a SET. By the way, it represents unordered data structure.
        // So, used different values to show associations more clearly
        ABM2mStudent aBM2mStudent = new ABM2mStudent("Sarah");
        ABM2mStudent aBM2mStudent2 = new ABM2mStudent("James");
        ABM2mStudent aBM2mStudent3 = new ABM2mStudent("Maggy");

        //create courses
        ABM2mCourse aBM2MCourse = new ABM2mCourse("Math");
        ABM2mCourse aBM2MCourse2 = new ABM2mCourse("Physics");
        ABM2mCourse aBM2MCourse3 = new ABM2mCourse("Philosophy");
        ABM2mCourse aBM2MCourse4 = new ABM2mCourse("Computer Science");

        // add courses to a Set
        Set<ABM2mCourse> aBM2mAcourses = new HashSet<ABM2mCourse>();
        aBM2mAcourses.add(aBM2MCourse2);
        aBM2mAcourses.add(aBM2MCourse3);
        aBM2mAcourses.add(aBM2MCourse4);

        aBM2mStudent3.setaBM2mAcourses(aBM2mAcourses); // set courses by a BM2mStudent
        aBM2MManager.persistAM2mS(aBM2mStudent3); // persist the BM2mStudent

        // add students to a Set
        Set<ABM2mStudent> aBM2mStudents = new HashSet<ABM2mStudent>();
        aBM2mStudents.add(aBM2mStudent);
        aBM2mStudents.add(aBM2mStudent2);

        aBM2MCourse.setStudents(aBM2mStudents); // set students by a Course
        aBM2MManager.persistAM2mC(aBM2MCourse); // persist the Course
    }
}
