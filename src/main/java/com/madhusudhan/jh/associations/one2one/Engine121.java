package com.madhusudhan.jh.associations.one2one;

// hibernate unidirectional one to one mapping
public class Engine121 {
    private int id = 0;
    private String make = null;
    private String model = null;
    private String size = null;

    private Car121 car121 = null;

    public Engine121() {
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

    public Car121 getCar121() {
        return car121;
    }

    public void setCar121(Car121 car121) {
        this.car121 = car121;
    }
}
