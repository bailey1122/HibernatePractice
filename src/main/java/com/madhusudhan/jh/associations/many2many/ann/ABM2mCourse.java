package com.madhusudhan.jh.associations.many2many.ann;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

// hibernate many2many bidirectional mapping
// owner entity
@Entity
@Table(name = "ABM2MCOURSE")
public class ABM2mCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID", updatable = false, nullable = false) // unique values
    private int id;
    private String title = null;

    // we use such the cascade to fix the problem "object references an unsaved transient
    // instance - save the transient instance before flushing"
    @ManyToMany()
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "ABM2MSTUDENT_COURSE", // make the associations. Make sure you're defining
            joinColumns = {@JoinColumn(name = "COURSE_ID")}, // right relevant columns
            inverseJoinColumns = {@JoinColumn(name = "STUDENT_ID")}) // like different from original
    Set<ABM2mStudent> aBM2mStudents = null;

    public ABM2mCourse() {
    }

    public ABM2mCourse(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<ABM2mStudent> getStudents() {
        return aBM2mStudents;
    }

    public void setStudents(Set<ABM2mStudent> students) {
        this.aBM2mStudents = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ABM2mCourse that = (ABM2mCourse) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return aBM2mStudents != null ? aBM2mStudents.equals(that.aBM2mStudents) : that.aBM2mStudents == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (aBM2mStudents != null ? aBM2mStudents.hashCode() : 0);
        return result;
    }
}
