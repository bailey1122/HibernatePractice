package com.madhusudhan.jh.hql;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "TRAVEL_REVIEW")
//@NamedQuery(name = "GET_TRAVEL_REVIEWS", // set the name query
//    query = "from com.madhusudhan.jh.hql.TravelReview")
@NamedQueries(
        value = {
                @NamedQuery(name = "GET_TRAVEL_REVIEWS", // set the name query
                    query = "from com.madhusudhan.jh.hql.TravelReview"),
                @NamedQuery(name = "GET_TRAVEL_REVIEWS_FOR_TITLE",
                        query = "from com.madhusudhan.jh.hql.TravelReview where title=:title")
        }
)
public class TravelReview  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRAVEL_ID")
    private int id;
    private String review = null;
    private String title = null;

    public TravelReview() {
    }

    public TravelReview(String review, String title) {
        this.review = review;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "TravelReview{" +
                "id=" + id +
                ", review='" + review + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
