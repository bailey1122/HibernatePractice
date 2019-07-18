package com.madhusudhan.jh.collections.list.ann;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity(name = "SHOWROOM_LIST_ANN")
@Table(name = "SHOWROOM_LIST_ANN")
public class AnnShowroom {
    @Id
    @Column(name = "SHOWROOM_ID")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;
    private String manager = null;
    private String location = null;

    @OneToMany
    @JoinColumn(name = "SHOWROOM_ID")
    @OrderColumn(name = "CAR_INDEX")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<AnnCar> cars = null;

    public AnnShowroom() {
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

    public List<AnnCar> getCars() {
        return cars;
    }

    public void setCars(List<AnnCar> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "AnnShowroom{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
