package com.madhusudhan.jh.advanced.inheritance.s3;

// the table-per-Concrete-Class strategy
public class ExecutiveI3 extends PersonI3 {
    private double bonus = 0.0;

    public ExecutiveI3() {
    }

    public ExecutiveI3(String name) {
        setName(name);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
