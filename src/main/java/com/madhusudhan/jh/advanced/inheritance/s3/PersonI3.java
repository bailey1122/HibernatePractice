package com.madhusudhan.jh.advanced.inheritance.s3;

// the table-per-Concrete-Class strategy.
// The base class
public abstract class PersonI3 {
    private int id = 0;
    private String name = "Person name"; // this name'll be defined in both child tables

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
