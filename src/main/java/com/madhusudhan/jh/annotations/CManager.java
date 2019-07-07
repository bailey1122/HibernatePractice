package com.madhusudhan.jh.annotations;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CManager {
    private void persistCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(course);
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
        CManager cManager = new CManager();
        Course course = new Course();
        CoursePK coursePK = new CoursePK();
        coursePK.setTutor("Prof. Harry Barry");
        coursePK.setTittle("Computer Science");

        course.setId(coursePK);
        course.setTotalStudents(20);
        course.setRegisteredStudents(12);
        cManager.persistCourse(course);
    }
}
