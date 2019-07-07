package com.madhusudhan.jh.associations.one2many.bi;

// hibernate bidirectional many to many mapping
// the owning side. A set side is inverse="true" by default, so we gotta turn it off
public class ActorB12m {
    private int id = 0;
    private String firstName = null;
    private String lastName = null;
    private String shortName = null;

    private MovieB12m movieB12mS = null;

    public ActorB12m() {
    }

    public ActorB12m(String firstName, String lastName, String shortName) {
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

    public MovieB12m getMovieB12mS() {
        return movieB12mS;
    }

    public void setMovieB12mS(MovieB12m movieB12mS) {
        this.movieB12mS = movieB12mS;
    }

    @Override
    public String toString() {
        return "ActorB12m{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", movieB12mS=" + movieB12mS +
                '}';
    }
}
