package com.madhusudhan.jh.hql;

// using named queries
public class TRNamedQueries {
    private int id;
    private String review = null;
    private String title = null;

    public TRNamedQueries() {
    }

    public TRNamedQueries(String title, String review) {
        this.title = title;
        this.review = review;
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "TRNamedQueries{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", review='" + review + '\'' +
                '}';
    }
}
