package com.madhusudhan.jh.associations.one2one.ann;

import javax.persistence.*;

// hibernate one to one mapping with shared primary key
@Entity
@Table(name = "CAR_P_ONE2ONE_ANN")
public class CarPAnn121 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID", updatable = false, nullable = false)
    private int id;
    private String name = null;
    private String color = null;

    @OneToOne(mappedBy = "carPAnn121")
    private EnginePAnn121 enginePAnn121;

    public CarPAnn121() {
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

    public EnginePAnn121 getEnginePAnn121() {
        return enginePAnn121;
    }

    public void setEnginePAnn121(EnginePAnn121 enginePAnn121) {
        this.enginePAnn121 = enginePAnn121;
    }
}
