package com.madhusudhan.jh.associations.many2many.ann;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

// hibernate many2many bidirectional mapping
// owner entity as well
@Entity
@Table(name = "ABM2MSTUDENT")
public class ABM2mStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID", updatable = false, nullable = false) // unique values
    private int id;
    private String name = null;

    // we use such the cascade to fix the problem "object references an unsaved transient
    // instance - save the transient instance before flushing"
    @ManyToMany()
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "ABM2MSTUDENT_COURSE",
            joinColumns = {@JoinColumn(name = "STUDENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "COURSE_ID")})
    private Set<ABM2mCourse> aBM2mAcourses = null;

    public ABM2mStudent() {
    }

    public ABM2mStudent(String name) {
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

    public Set<ABM2mCourse> getaBM2mAcourses() {
        return aBM2mAcourses;
    }

    public void setaBM2mAcourses(Set<ABM2mCourse> aBM2mAcourses) {
        this.aBM2mAcourses = aBM2mAcourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ABM2mStudent aBM2mStudent = (ABM2mStudent) o;

        if (id != aBM2mStudent.id) return false;
        if (name != null ? !name.equals(aBM2mStudent.name) : aBM2mStudent.name != null) return false;
        return aBM2mAcourses != null ? aBM2mAcourses.equals(aBM2mStudent.aBM2mAcourses) : aBM2mStudent.aBM2mAcourses == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (aBM2mAcourses != null ? aBM2mAcourses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ABM2mStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
