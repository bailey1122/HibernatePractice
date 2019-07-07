package com.madhusudhan.jh.collections.array;

import java.util.Arrays;

public class ShowroomA {
    private int id = 0;
    private String manager = null;
    private String location = null;
    private String[] cars = null;

    public ShowroomA() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String[] getCars() {
        return cars;
    }

    public void setCars(String[] cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ShowroomA{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + Arrays.toString(cars) +
                '}';
    }
}
