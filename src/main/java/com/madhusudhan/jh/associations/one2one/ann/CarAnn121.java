package com.madhusudhan.jh.associations.one2one.ann;

import com.madhusudhan.jh.associations.one2one.Engine_2_121;

import javax.persistence.*;

// hibernate one to one mapping with foreign key association
@Entity
@Table(name = "CAR_ONE2ONE_ANN")
public class CarAnn121 {
////    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car121ann_gen")
//    @SequenceGenerator(name = "car121ann_gen", sequenceName = "c_seq")
//    @Column(name = "CAR_ID", updatable = false, nullable = false)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID", updatable = false, nullable = false)
    private int id;
    private String name = null;
    private String color = null;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "ENGINE_ID")
    private EngineAnn121 engineAnn121 = null;

    public CarAnn121() {
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

    public EngineAnn121 getEngineAnn121() {
        return engineAnn121;
    }

    public void setEngineAnn121(EngineAnn121 engineAnn121) {
        this.engineAnn121 = engineAnn121;
    }
}
