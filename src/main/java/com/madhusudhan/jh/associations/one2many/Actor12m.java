package com.madhusudhan.jh.associations.one2many;

// hibernate unidirectional one to many mapping. Not as efficient
// as bidirectional. DON'T USE this type of associations 'cause
// Hibernate might create unexpected tables and execute more SQL
// statements than you expected. That happens 'cause you don't model
// the relationship on the entity, which represents the to-many side
// of relationship. So, use a bidirectional mapping.
public class Actor12m {
    private int id = 0;
    private String firstName = null;
    private String lastName = null;
    private String shortName = null;

    public Actor12m() {
    }

    public Actor12m(String firstName, String lastName, String shortName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.shortName = shortName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
