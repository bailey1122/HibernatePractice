package com.madhusudhan.jh.advanced.inheritance.s3.ann;

import com.madhusudhan.jh.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

// the table-per-Concrete-Class strategy
public class AInherStrategy3Test {
    private void persistInhEmp(EmployeeI3A employeeI3A) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(employeeI3A);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null)
                tx.rollback();
            throw ex;
        } finally {
            session.close();
        }
    }

    private void persistInhEx(ExecutiveI3A executiveI3A) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(executiveI3A);
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
        AInherStrategy3Test aInherStrategy3Test = new AInherStrategy3Test();

        EmployeeI3A employeeI3A = new EmployeeI3A();
        employeeI3A.setRole("Director");
        ExecutiveI3A executiveI3A = new ExecutiveI3A();
        executiveI3A.setBonus(140.00);

        aInherStrategy3Test.persistInhEmp(employeeI3A);
        aInherStrategy3Test.persistInhEx(executiveI3A);
    }
}
