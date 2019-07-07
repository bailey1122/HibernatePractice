package com.madhusudhan.jh.collections.idbags;

import java.util.List;

public class ShowroomI {
    private int id = 0;
    private String manager = null;
    private String location = null;
    private List<CarI> cars = null;

    public ShowroomI() {
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

    public List<CarI> getCars() {
        return cars;
    }

    public void setCars(List<CarI> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ShowroomI{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
