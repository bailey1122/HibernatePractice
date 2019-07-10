package com.madhusudhan.jh.advanced.inheritance.s1;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InherStrategy1Test {
    private void persistInhEmp(EmployeeI1 employeeI1) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(employeeI1);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void persistInhEx(ExecutiveI1 executiveI1) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(executiveI1);
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
        InherStrategy1Test inherStrategy1Test = new InherStrategy1Test();

        EmployeeI1 emp = new EmployeeI1("Barry Bumbles");
        ExecutiveI1 ex = new ExecutiveI1("Harry Dumbles");
        ex.setRole("Manager");

        inherStrategy1Test.persistInhEmp(emp);
        inherStrategy1Test.persistInhEx(ex);
    }
}
