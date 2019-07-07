package com.madhusudhan.jh.associations.one2many;

import java.util.Set;

// hibernate unidirectional one to many mapping. Not as efficient
// as bidirectional. DON'T USE this type of associations 'cause
// Hibernate might create unexpected tables and execute more SQL
// statements than you expected. That happens 'cause you don't model
// the relationship on the entity, which represents the to-many side
// of relationship. So, use a bidirectional mapping.
public class Movie12m {
    private int id = 0;
    private String title = null;
    private Set<Actor12m> actor12ms = null;

    public Movie12m() {
    }

    public Movie12m(String title) {
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

    public Set<Actor12m> getActor12ms() {
        return actor12ms;
    }

    public void setActor12ms(Set<Actor12m> actor12ms) {
        this.actor12ms = actor12ms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie12m movie12m = (Movie12m) o;

        if (id != movie12m.id) return false;
        if (title != null ? !title.equals(movie12m.title) : movie12m.title != null) return false;
        return actor12ms != null ? actor12ms.equals(movie12m.actor12ms) : movie12m.actor12ms == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (actor12ms != null ? actor12ms.hashCode() : 0);
        return result;
    }
}
