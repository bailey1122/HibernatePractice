package com.madhusudhan.jh.annotations;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CoursePK implements Serializable {
    private String tutor = null;
    private String tittle = null;

    // Default constructor
    public CoursePK() {
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursePK coursePK = (CoursePK) o;

        if (tutor != null ? !tutor.equals(coursePK.tutor) : coursePK.tutor != null) return false;
        return tittle != null ? tittle.equals(coursePK.tittle) : coursePK.tittle == null;
    }

    @Override
    public int hashCode() {
        int result = tutor != null ? tutor.hashCode() : 0;
        result = 31 * result + (tittle != null ? tittle.hashCode() : 0);
        return result;
    }
}
