package com.madhusudhan.jh.associations.one2many;

import javax.persistence.*;

// hibernate unidirectional one to many mapping. Not as efficient
// as bidirectional. DON'T USE this type of associations 'cause
// Hibernate might create unexpected tables and execute more SQL
// statements than you expected. That happens 'cause you don't model
// the relationship on the entity, which represents the to-many side
// of relationship. So, use a bidirectional mapping.
@Entity
@Table(name = "AACTOR12M")
public class AActor12m {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTOR_ID")
    private int id;
    private String fname = null;
    private String lname = null;
    private String sname = null;

    public AActor12m() {
    }

    public AActor12m(String fname, String lname, String sname) {
        this.fname = fname;
        this.lname = lname;
        this.sname = sname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
