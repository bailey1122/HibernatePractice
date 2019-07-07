package com.madhusudhan.jh.associations.many2many;

import java.util.Set;

// hibernate many2many bidirectional mapping
public class BM2mStudent {
    private int id = 0;
    private String name = null;

    // bidirectional. To save Course when we save BM2mStudent and
    private Set<BM2mCourse> bM2MCourses = null; // vice versa

    public BM2mStudent() {
    }


//    public void addCourse(BM2mCourse m2mCourse) {
//        this.bM2MCourses.add(m2mCourse);
//        m2mCourse.getbM2MStudents().add(this);
//    }
//
//    public void removeCourse(BM2mCourse m2mCourse) {
//        this.bM2MCourses.remove(m2mCourse);
//        m2mCourse.getbM2MStudents().remove(this);
//    }


    public BM2mStudent(String name) {
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

    public Set<BM2mCourse> getbM2MCourses() {
        return bM2MCourses;
    }

    public void setbM2MCourses(Set<BM2mCourse> bM2MCourses) {
        this.bM2MCourses = bM2MCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BM2mStudent bM2MStudent = (BM2mStudent) o;

        if (id != bM2MStudent.id) return false;
        if (name != null ? !name.equals(bM2MStudent.name) : bM2MStudent.name != null) return false;
        return bM2MCourses != null ? bM2MCourses.equals(bM2MStudent.bM2MCourses) : bM2MStudent.bM2MCourses == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (bM2MCourses != null ? bM2MCourses.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BM2mStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
