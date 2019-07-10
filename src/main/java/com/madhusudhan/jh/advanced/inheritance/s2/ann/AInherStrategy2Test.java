package com.madhusudhan.jh.advanced.inheritance.s2.ann;

import com.madhusudhan.jh.HibernateUtil;
import com.madhusudhan.jh.advanced.inheritance.s2.ExecutiveI2;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// the table-per-Subclass strategy
public class AInherStrategy2Test {
    private void persistInhEmp(EmployeeI2A employeeI2A) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(employeeI2A);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void persistInhEx(ExecutiveI2A executiveI2A) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(executiveI2A);
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
        AInherStrategy2Test aInherStrategy2Test = new AInherStrategy2Test();

        EmployeeI2A employeeI2A = new EmployeeI2A("Barry Bumbles");
        ExecutiveI2A executiveI2A = new ExecutiveI2A("Harry Dumbles");
        executiveI2A.setRole("Director");

        aInherStrategy2Test.persistInhEmp(employeeI2A);
        aInherStrategy2Test.persistInhEx(executiveI2A);
    }
}
