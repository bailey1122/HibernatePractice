package com.madhusudhan.jh.advanced.inheritance.s3;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// the table-per-Concrete-Class strategy
public class InherStrategy3Test {
    private void persistInhEmp(EmployeeI3 employeeI3) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(employeeI3);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void persistInhEx(ExecutiveI3 executiveI3) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(executiveI3);
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
        InherStrategy3Test inherStrategy3Test = new InherStrategy3Test();

        EmployeeI3 employeeI3 = new EmployeeI3("Barry Bumbles");
        employeeI3.setRole("Director");
        ExecutiveI3 executiveI3 = new ExecutiveI3("Harry Dumbles");
        executiveI3.setBonus(100.00);

        inherStrategy3Test.persistInhEmp(employeeI3);
        inherStrategy3Test.persistInhEx(executiveI3);
    }
}
