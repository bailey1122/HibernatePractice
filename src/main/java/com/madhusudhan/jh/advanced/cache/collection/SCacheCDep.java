package com.madhusudhan.jh.advanced.cache.collection;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// the second level caching and a collection
@Entity
@Table(name = "S_CACHE_COLL_DEPT")
@Cacheable // a necessary annotation
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SCacheCDep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID")
    private int id;
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sCacheCDeps")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE) // set @Cache when you use Collections
    private List<SCacheCPerson> sCacheCPersons = new ArrayList<SCacheCPerson>();

    public SCacheCDep() {
    }

    public SCacheCDep(String name) {
        this.name = name;
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

    public List<SCacheCPerson> getsCacheCPersons() {
        return sCacheCPersons;
    }

    public void setsCacheCPersons(List<SCacheCPerson> sCacheCPersons) {
        this.sCacheCPersons = sCacheCPersons;
    }

    @Override
    public String toString() {
        return "SCacheCDep{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
