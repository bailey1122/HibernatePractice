package com.madhusudhan.jh.collections.set.ann;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "SHOWROOM_SET_ANN_JOINTABLE")
@Table(name = "SHOWROOM_SET_ANN_JOINTABLE")
public class AnnJoinShowroom {
    @Id
    @Column(name = "SHOWROOM_ID")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;
    private String manager = null;
    private String location = null;

    @OneToMany
    @JoinTable(name = "SHOWROOM_CAR_SET_ANN_JOINTABLE",
    joinColumns = @JoinColumn(name = "SHOWROOM_ID"))
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<AnnJoinCar> cars = null;

    public AnnJoinShowroom() {
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

    public Set<AnnJoinCar> getCars() {
        return cars;
    }

    public void setCars(Set<AnnJoinCar> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "AnnJoinShowroom{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
