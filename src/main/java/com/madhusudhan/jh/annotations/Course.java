package com.madhusudhan.jh.annotations;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// if you don't use @Table then hibernate consider that @Entity is your table name by default
@Entity // allow you to access your table with the same name as the entity while writing HQL or JPQL
// name of the table. Use the same name like an entity when naming @Entity
@Table(name="COURSE_ANNOTATION") // or use this with no name @Entity
public class Course {
    @Id
    private CoursePK id = null;
    private int totalStudents = 0;
    private int registeredStudents = 0;

    public Course() {
    }

    public CoursePK getId() {
        return id;
    }

    public void setId(CoursePK id) {
        this.id = id;
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
