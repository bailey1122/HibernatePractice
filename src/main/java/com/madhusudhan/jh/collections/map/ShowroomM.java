package com.madhusudhan.jh.collections.map;

import java.util.Map;

public class ShowroomM {
    private int id = 0;
    private String manager = null;
    private String location = null;
    private Map<String, CarM> cars = null;

    public ShowroomM() {
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

    public Map<String, CarM> getCars() {
        return cars;
    }

    public void setCars(Map<String, CarM> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ShowroomM{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
