package com.madhusudhan.jh.advanced.inheritance.s3.ann;

import javax.persistence.*;

// the table-per-Concrete-Class strategy.
// The base class
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // the main strategy point
public abstract class PersonI3A {
    @Id
    @GeneratedValue() // the native identifier strategy isn't allowed here
    @Column(name = "EMPLOYEE_ID")
    private int id = 0;
    private String name = null;

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
