package com.madhusudhan.jh.associations.one2many;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

// hibernate unidirectional one to many mapping. Not as efficient
// as bidirectional. DON'T USE this type of associations 'cause
// Hibernate might create unexpected tables and execute more SQL
// statements than you expected. That happens 'cause you don't model
// the relationship on the entity, which represents the to-many side
// of relationship. So, use a bidirectional mapping.
@Entity
@Table(name = "AMOVIE12M")
public class AMovie12m {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private int id;
    private String title = null;

    @OneToMany()
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    // if there are any reasons not to use a bidirectional relationship,
    @JoinColumn(name = "MOVIE_ID") // we can add @JoinColumn to avoid a junction table
    private Set<AActor12m> aaActor12ms = null;

    public AMovie12m() {
    }

    public AMovie12m(String title) {
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

    public Set<AActor12m> getAaActor12ms() {
        return aaActor12ms;
    }

    public void setAaActor12ms(Set<AActor12m> aaActor12ms) {
        this.aaActor12ms = aaActor12ms;
    }
}
