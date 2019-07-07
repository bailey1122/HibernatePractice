package com.madhusudhan.jh.associations.one2one;

// hibernate bidirectional one to one mapping
public class Car_2_121 {
    private int id;
    private String name;
    private String color;

    private Engine_2_121 engine_2_121;

    public Car_2_121() {
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

    public Engine_2_121 getEngine_2_121() {
        return engine_2_121;
    }

    public void setEngine_2_121(Engine_2_121 engine_2_121) {
        this.engine_2_121 = engine_2_121;
    }
}