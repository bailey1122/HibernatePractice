package com.madhusudhan.jh.advanced.inheritance.s1.ann;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// the table-per-class strategy for persisting the test data.
// If you use this strategy, you cannot declare NOT NULL
// constraints on the column related to the subclasses
@Entity()
@DiscriminatorValue(value = "EXECUTIVE")
public class ExecutiveI1A extends EmployeeI1A {
    private String role = null;

    public ExecutiveI1A() {
    }

    public ExecutiveI1A(String name) {
        super(name);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
