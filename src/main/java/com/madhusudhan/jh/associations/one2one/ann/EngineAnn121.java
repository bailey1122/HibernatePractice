package com.madhusudhan.jh.associations.one2one.ann;

import javax.persistence.*;

// hibernate one to one mapping with foreign key association
@Entity
@Table(name = "ENGINE_ONE2ONE_ANN")
public class EngineAnn121 {
////    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "engine121_ann_gen") // the best approach
//    @SequenceGenerator(name = "engine121_ann_gen", sequenceName = "e_seq")
//    @Column(name = "ENGINE_ID", updatable = false, nullable = false) // unique values

    // this approach has significant drawback if you use Hibernate.
    // Hibernate requires a primary key value for each managed entity
    // and therefore has to perform the insert statement immediately.
    // This prevents it from using different optimization techniques like
    // JDBC batching.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENGINE_ID", updatable = false, nullable = false)
   private int id;
    private String make = null;
    private String model = null;
    private String size = null;

    @OneToOne(mappedBy = "engineAnn121")
    private CarAnn121 carAnn121 = null;

    public EngineAnn121() {
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

    public CarAnn121 getCarAnn121() {
        return carAnn121;
    }

    public void setCarAnn121(CarAnn121 carAnn121) {
        this.carAnn121 = carAnn121;
    }
}
