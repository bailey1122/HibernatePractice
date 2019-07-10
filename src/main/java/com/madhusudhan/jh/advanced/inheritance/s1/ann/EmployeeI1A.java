package com.madhusudhan.jh.advanced.inheritance.s1.ann;

import javax.persistence.*;

// the table-per-class strategy for persisting the test data.
// If you use this strategy, you cannot declare NOT NULL
// constraints on the column related to the subclasses.
// The main (parent) class
@Entity(name = "INHERITANCE_S1_EMPLOYEE_ANN")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // don't be tempted to set an
@DiscriminatorColumn(name = "DISCRIMINATOR", // InheritanceType.TABLE_PER_CLASS value
    discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "EMPLOYEE")
public class EmployeeI1A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private int id = 0;
    private String name = null;
    private String role = null;

    public EmployeeI1A() {
    }

    public EmployeeI1A(String name) {
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
