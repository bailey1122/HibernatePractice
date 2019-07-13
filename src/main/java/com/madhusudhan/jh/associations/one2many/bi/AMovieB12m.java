package com.madhusudhan.jh.associations.one2many.bi;

import javax.persistence.*;
import java.util.Set;

// hibernate bidirectional many to many mapping
// inverse or the referencing side. A set side is inverse="true" by default
@Entity
@Table(name = "AMOVIEB12M")
public class AMovieB12m {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private int id;
    private String title = null;

    @OneToMany(cascade = CascadeType.ALL) // the owning side
    @JoinColumn(name = "MOVIE_ID", nullable = false)
    private Set<AActorB12m> aActorB12ms = null;

    public AMovieB12m() {
    }

    public AMovieB12m(String title) {
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

    public Set<AActorB12m> getaActorB12ms() {
        return aActorB12ms;
    }

    public void setaActorB12ms(Set<AActorB12m> aActorB12ms) {
        this.aActorB12ms = aActorB12ms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AMovieB12m that = (AMovieB12m) o;

        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return aActorB12ms != null ? aActorB12ms.equals(that.aActorB12ms) : that.aActorB12ms == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (aActorB12ms != null ? aActorB12ms.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AMovieB12m{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
