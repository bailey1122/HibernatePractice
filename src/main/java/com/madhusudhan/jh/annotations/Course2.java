package com.madhusudhan.jh.annotations;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE_ANNOTATION_V2")
public class Course2 {
    @EmbeddedId
    private CoursePK2 id = null;
    private int totalStudents = 0;
    private int registeredStudents = 0;

    public Course2() {
    }

    public Course2(String title, String tutor) {
        id = new CoursePK2();
        id.setTittle(title);
        id.setTutor(tutor);
    }


    public CoursePK2 getId() {
        return id;
    }

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(int registeredStudents) {
        this.registeredStudents = registeredStudents;
    }
}
