package com.madhusudhan.jh.advanced.inheritance.s2;

// the table-per-Subclass strategy
public class ExecutiveI2 extends EmployeeI2 {
    private String role = null;

    public ExecutiveI2() {
    }

    public ExecutiveI2(String name) {
        super(name);
    }

    @Override
    public String getRole() {
        return role;
    }

    @Override
    public void setRole(String role) {
        this.role = role;
    }
}
