package com.madhusudhan.jh.hql;

public class City {
    private String title = null;
    private String description = null;

    public City() {
    }

    public City(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "City{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
