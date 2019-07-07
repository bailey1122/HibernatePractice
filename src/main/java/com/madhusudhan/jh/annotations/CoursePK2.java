package com.madhusudhan.jh.annotations;

import java.io.Serializable;

public class CoursePK2 implements Serializable {
    private String tutor = null;
    private String tittle = null;

    // Default constructor
    public CoursePK2() {
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

    // Implement hashCode and equals methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoursePK2 coursePK2 = (CoursePK2) o;

        if (tutor != null ? !tutor.equals(coursePK2.tutor) : coursePK2.tutor != null) return false;
        return tittle != null ? tittle.equals(coursePK2.tittle) : coursePK2.tittle == null;
    }

    @Override
    public int hashCode() {
        int result = tutor != null ? tutor.hashCode() : 0;
        result = 31 * result + (tittle != null ? tittle.hashCode() : 0);
        return result;
    }
}
