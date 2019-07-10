package com.madhusudhan.jh.advanced.inheritance.s3;

// the table-per-Concrete-Class strategy
public class EmployeeI3 extends PersonI3{
    private String role = null;

    public EmployeeI3() {
    }

    public EmployeeI3(String name) {
        setName(name);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
