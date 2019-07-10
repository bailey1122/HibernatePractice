package com.madhusudhan.jh.advanced.inheritance.s2;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// the table-per-Subclass strategy
public class InherStrategy2Test {
    private void persistInhEmp(EmployeeI2 employeeI2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(employeeI2);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void persistInhEx(ExecutiveI2 executiveI2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(executiveI2);
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
        InherStrategy2Test inherStrategy2Test = new InherStrategy2Test();
        EmployeeI2 emp = new EmployeeI2("Barry Bumbles");
        ExecutiveI2 ex = new ExecutiveI2("Harry Dumbles");
        ex.setRole("Director");

        inherStrategy2Test.persistInhEmp(emp);
        inherStrategy2Test.persistInhEx(ex);
    }
}