package com.madhusudhan.jh.associations.one2one;

// hibernate unidirectional one to one mapping
public class Car121 {
    private int id;
    private String name;
    private String color;

    private Engine121 engine121;

    public Car121() {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Engine121 getEngine121() {
        return engine121;
    }

    public void setEngine121(Engine121 engine121) {
        this.engine121 = engine121;
    }
}
