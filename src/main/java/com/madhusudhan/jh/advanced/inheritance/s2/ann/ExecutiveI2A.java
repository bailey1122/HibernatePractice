package com.madhusudhan.jh.advanced.inheritance.s2.ann;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

// the table-per-Subclass strategy
@Entity(name = "INHERITANCE_S2_EXECUTIVE_ANN")
@PrimaryKeyJoinColumn(name = "EMPLOYEE_ID")
public class ExecutiveI2A extends EmployeeI2A{
    private String role = null;

    public ExecutiveI2A() {
    }

    public ExecutiveI2A(String name) {
        super(name);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
