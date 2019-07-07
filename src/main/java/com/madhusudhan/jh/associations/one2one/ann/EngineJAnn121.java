package com.madhusudhan.jh.associations.one2one.ann;

import javax.persistence.*;

// hibernate one to one mapping with common join table
@Entity
@Table(name = "ENGINE_J_ONE2ONE_ANN")
public class EngineJAnn121 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENGINE_ID", updatable = false, nullable = false)
    private int id;
    private String make = null;
    private String model = null;
    private String size = null;

    public EngineJAnn121() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
