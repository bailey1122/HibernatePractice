package com.madhusudhan.jh.collections.set;

import java.util.Set;

public class ShowroomS {
    private int id = 0;
    private String manager = null;
    private String location = null;
    private Set<CarS> cars = null; // Set example

    public ShowroomS() {
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

    public Set<CarS> getCars() {
        return cars;
    }

    public void setCars(Set<CarS> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "ShowroomS{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
