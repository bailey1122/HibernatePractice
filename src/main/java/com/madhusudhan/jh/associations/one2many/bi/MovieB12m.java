package com.madhusudhan.jh.associations.one2many.bi;

import java.util.Set;

// hibernate bidirectional many to many mapping
// inverse or the referencing side. A set side is inverse="true" by default
public class MovieB12m {
    private int id = 0;
    private String title = null;
    private Set<ActorB12m> actorB12ms = null;

    public MovieB12m() {
    }


    public MovieB12m(String title) {
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

    public Set<ActorB12m> getActorB12ms() {
        return actorB12ms;
    }

    public void setActorB12ms(Set<ActorB12m> actorB12ms) {
        this.actorB12ms = actorB12ms;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MovieB12m movieB12m = (MovieB12m) o;

        if (id != movieB12m.id) return false;
        if (title != null ? !title.equals(movieB12m.title) : movieB12m.title != null) return false;
        return actorB12ms != null ? actorB12ms.equals(movieB12m.actorB12ms) : movieB12m.actorB12ms == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (actorB12ms != null ? actorB12ms.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MovieB12m{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
