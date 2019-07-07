package com.madhusudhan.jh.associations.one2one.ann;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

// hibernate one to one mapping with shared primary key
@Entity
@Table(name = "ENGINE_P_ONE2ONE_ANN")
public class EnginePAnn121 {
    @Id
    @Column(name = "CAR_ID")
    private int id;
    private String make = null;
    private String model = null;
    private String size = null;

    @OneToOne
    @JoinColumn(name = "CAR_ID") // specify the association
    @MapsId // tells Hibernate to use the pk value o the CarPAnn121 as the pk value of the EnginePAnn121
    private CarPAnn121 carPAnn121;

    public EnginePAnn121() {
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

    public CarPAnn121 getCarPAnn121() {
        return carPAnn121;
    }

    public void setCarPAnn121(CarPAnn121 carPAnn121) {
        this.carPAnn121 = carPAnn121;
    }
}
