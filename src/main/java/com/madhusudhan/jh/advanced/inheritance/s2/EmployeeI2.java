package com.madhusudhan.jh.advanced.inheritance.s2;

// the table-per-Subclass strategy.
// The main (parent) class
public class EmployeeI2 {
    private int id = 0;
    private String name = null;
    private String role = null; // we gotta delete this when using annotation

    public EmployeeI2() {
    }

    public EmployeeI2(String name) {
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
