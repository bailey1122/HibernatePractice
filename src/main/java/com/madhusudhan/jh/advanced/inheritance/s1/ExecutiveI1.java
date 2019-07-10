package com.madhusudhan.jh.advanced.inheritance.s1;

// the table-per-class strategy for persisting the test data.
// If you use this strategy, you cannot declare NOT NULL
// constraints on the column related to the subclasses
public class ExecutiveI1 extends EmployeeI1 {
    private String role = null;

    public ExecutiveI1() {
    }

    public ExecutiveI1(String name) {
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
