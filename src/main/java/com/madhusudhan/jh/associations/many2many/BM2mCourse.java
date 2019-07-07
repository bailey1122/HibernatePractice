package com.madhusudhan.jh.associations.many2many;

import java.util.Set;

// hibernate many2many bidirectional mapping
public class BM2mCourse {
    private int id = 0;
    private String title = null;

    // bidirectional. To save Course when we save BM2mStudent and
    private Set<BM2mStudent> bM2MStudents = null; // vice versa

    public BM2mCourse() {
    }

    public BM2mCourse(String title) {
        this.title = title;
    }


//        public void addStudent(BM2mStudent student) {
//        this.bM2MStudents.add(student);
//        student.getbM2MCourses().add(this);
//    }
//
//    public void removeStudent(BM2mStudent student) {
//        this.bM2MStudents.remove(student);
//        student.getbM2MCourses().remove(this);
//    }


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

    public Set<BM2mStudent> getbM2MStudents() {
        return bM2MStudents;
    }

    public void setbM2MStudents(Set<BM2mStudent> bM2MStudents) {
        this.bM2MStudents = bM2MStudents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BM2mCourse bM2MCours = (BM2mCourse) o;

        if (id != bM2MCours.id) return false;
        if (title != null ? !title.equals(bM2MCours.title) : bM2MCours.title != null) return false;
        return bM2MStudents != null ? bM2MStudents.equals(bM2MCours.bM2MStudents) : bM2MCours.bM2MStudents == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (bM2MStudents != null ? bM2MStudents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BM2mCourse{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
