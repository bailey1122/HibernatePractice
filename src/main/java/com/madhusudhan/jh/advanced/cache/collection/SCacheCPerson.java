package com.madhusudhan.jh.advanced.cache.collection;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

// the second level caching and a collection
@Entity
@Table(name = "S_CACHE_COLL_PERSON")
@Cacheable // a necessary annotation
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE) // a strategy of cache
public class SCacheCPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID")
    private int id;
    private String fname = null;
    private String lname = null;
    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    private SCacheCDep sCacheCDeps = null;

    public SCacheCPerson() {
    }

    public SCacheCPerson(String fname, String lname, int age) {
        this.fname = fname;
        this.lname = lname;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SCacheCDep getsSCacheCDeps() {
        return sCacheCDeps;
    }

    public void setsSCacheCDeps(SCacheCDep sCacheCDe) {
        this.sCacheCDeps = sCacheCDe;
    }

    @Override
    public String toString() {
        return "SCacheCPerson{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", age=" + age +
                ", sCacheCDe=" + sCacheCDeps +
                '}';
    }
}
