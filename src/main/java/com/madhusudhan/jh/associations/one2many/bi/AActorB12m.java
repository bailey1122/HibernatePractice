package com.madhusudhan.jh.associations.one2many.bi;

import javax.persistence.*;

// hibernate bidirectional many to many mapping
// the owning side. A set side is inverse="true" by default, so we gotta turn it off
@Entity
@Table(name = "AACTORB12M")
public class AActorB12m {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTOR_ID")
    private int id;
    private String fname = null;
    private String lname = null;
    private String sname = null;

    @ManyToOne() // inverse side
//    inverse="false" here by parameters updatable=false, nullable=false, insertable=false
    @JoinColumn(name = "MOVIE_ID", updatable = false, nullable = false,
            insertable = false)
    private AMovieB12m aMovieB12mS = null;

    public AActorB12m() {
    }

    public AActorB12m(String fname, String lname, String sname) {
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

    public AMovieB12m getaMovieB12mS() {
        return aMovieB12mS;
    }

    public void setaMovieB12mS(AMovieB12m aMovieB12mS) {
        this.aMovieB12mS = aMovieB12mS;
    }

    @Override
    public String toString() {
        return "AActorB12m{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", sname='" + sname + '\'' +
                ", aMovieB12mS=" + aMovieB12mS +
                '}';
    }
}
