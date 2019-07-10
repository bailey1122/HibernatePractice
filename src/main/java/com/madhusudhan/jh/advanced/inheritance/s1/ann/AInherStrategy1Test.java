package com.madhusudhan.jh.advanced.inheritance.s1.ann;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// the table-per-class strategy for persisting the test data.
// If you use this strategy, you cannot declare NOT NULL
// constraints on the column related to the subclasses
public class AInherStrategy1Test {
    private void persistInhEmp(EmployeeI1A employeeI1A) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(employeeI1A);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void persistInhEx(ExecutiveI1A executiveI1A) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(executiveI1A);
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
        AInherStrategy1Test aInherStrategy1Test = new AInherStrategy1Test();

        EmployeeI1A emp = new EmployeeI1A("Barry Bumbles");
        ExecutiveI1A ex = new ExecutiveI1A("Harry Dumbles");
        ex.setRole("Director");

        aInherStrategy1Test.persistInhEmp(emp);
        aInherStrategy1Test.persistInhEx(ex);
    }
}
