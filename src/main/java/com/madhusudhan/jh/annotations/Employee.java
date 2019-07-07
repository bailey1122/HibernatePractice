package com.madhusudhan.jh.annotations;

import javax.persistence.*;

@Entity(name = "TBL_EMPLOYEE")
public class Employee {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "empSeqGen")
    @SequenceGenerator(name = "empSeqGen", sequenceName = "EMP_SEQ_GEN")
    private int employeeId = 0;

    public Employee() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
