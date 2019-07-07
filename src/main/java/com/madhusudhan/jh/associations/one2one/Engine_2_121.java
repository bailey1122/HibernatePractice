package com.madhusudhan.jh.associations.one2one;

// hibernate bidirectional one to one mapping
public class Engine_2_121 {
    private int id = 0;
    private String make = null;
    private String model = null;
    private String size = null;

    public Engine_2_121() {
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
