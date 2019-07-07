package com.madhusudhan.jh.associations.one2one.ann;

import javax.persistence.*;

// hibernate one to one mapping with common join table
@Entity
@Table(name = "CAR_J_ONE2ONE_ANN")
public class CarJAnn121 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID", updatable = false, nullable = false)
    private int id;
    private String name = null;
    private String color = null;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "CAR_ENG_JOIN", joinColumns = { // it declares new table and columns
    @JoinColumn(name = "J_CAR_ID", referencedColumnName = "CAR_ID")},
    inverseJoinColumns = { @JoinColumn(name = "J_ENGINE_ID", referencedColumnName = "ENGINE_ID")})
    private EngineJAnn121 engineJAnn121;

    public CarJAnn121() {
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

    public EngineJAnn121 getEngineJAnn121() {
        return engineJAnn121;
    }

    public void setEngineJAnn121(EngineJAnn121 engineJAnn121) {
        this.engineJAnn121 = engineJAnn121;
    }
}
