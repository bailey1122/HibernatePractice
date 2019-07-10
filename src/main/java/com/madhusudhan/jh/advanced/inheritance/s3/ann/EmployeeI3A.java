package com.madhusudhan.jh.advanced.inheritance.s3.ann;

import javax.persistence.Entity;

// the table-per-Concrete-Class strategy
@Entity(name = "INHERITANCE_S3_EMPLOYEE_ANN")
public class EmployeeI3A extends PersonI3A {
    private String role = null;

    public EmployeeI3A() {
    }

    public EmployeeI3A(String name) {
        setName(name);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
