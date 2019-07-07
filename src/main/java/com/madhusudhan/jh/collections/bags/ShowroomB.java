package com.madhusudhan.jh.collections.bags;

import java.util.List;

public class ShowroomB {
    private int id = 0;
    private String manager = null;
    private String location = null;
    private List<CarB> cars = null;

    public ShowroomB() {
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

    public List<CarB> getCars() {
        return cars;
    }

    public void setCars(List<CarB> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ShowroomB{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
