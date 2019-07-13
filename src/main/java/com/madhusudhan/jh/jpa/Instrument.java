package com.madhusudhan.jh.jpa;

import javax.persistence.*;

// JPA
@Entity
@Table(name = "INSTRUMENT_JPA")
public class Instrument {
    @Id
    @Column(name = "INSTRUMENT_ID")
    private int id = 0;
    private String name = null;
    private String make = null;

    public Instrument() {
    }

    public Instrument(int id, String name, String make) {
        this.id = id;
        this.name = name;
        this.make = make;
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

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", make='" + make + '\'' +
                '}';
    }
}
