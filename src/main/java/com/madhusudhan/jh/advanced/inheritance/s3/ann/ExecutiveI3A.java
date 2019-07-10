package com.madhusudhan.jh.advanced.inheritance.s3.ann;

import javax.persistence.Entity;

// the table-per-Concrete-Class strategy
@Entity(name = "INHERITANCE_S3_EXECUTIVE_ANN")
public class ExecutiveI3A extends PersonI3A {
    private double bonus = 0.0;

    public ExecutiveI3A() {
    }

    public ExecutiveI3A(String name) {
        setName(name);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
