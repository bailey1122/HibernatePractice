package com.madhusudhan.jh.advanced.cache;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

// the second level caching
@Entity
@Table(name = "S_CACHE_PERSON")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SCachePerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private int id;
    private String fname = null;
    private String lname = null;
    private String nname = null;

    public SCachePerson() {
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

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    @Override
    public String toString() {
        return "SCachePerson{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", nname='" + nname + '\'' +
                '}';
    }
}
