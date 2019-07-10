package com.madhusudhan.jh.advanced.inheritance.s1;

// the table-per-class strategy for persisting the test data.
// If you use this strategy, you cannot declare NOT NULL
// constraints on the column related to the subclasses.
// The main (parent) class
public class EmployeeI1 {
    private int id = 0;
    private String name = null;
    private String role = null;

    public EmployeeI1() {
    }

    public EmployeeI1(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
