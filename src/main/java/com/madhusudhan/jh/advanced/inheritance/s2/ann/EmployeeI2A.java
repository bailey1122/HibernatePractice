package com.madhusudhan.jh.advanced.inheritance.s2.ann;

import javax.persistence.*;

// the table-per-Subclass strategy.
// The main (parent) class
@Entity(name = "INHERITANCE_S2_EMPLOYEE_ANN")
@Inheritance(strategy = InheritanceType.JOINED) // setting the strategy to table-per-subclass
public class EmployeeI2A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private int id = 0;
    private String name = null;

    public EmployeeI2A() {
    }

    public EmployeeI2A(String name) {
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

}
