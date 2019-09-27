package com.codeup.silverlining.Model;

import javax.persistence.*;

@Entity
@Table(name= "Reviews")
public class Review {
    @Id @GeneratedValue
    private long id;

    @Column(name = "Rating")
    private long rating;

    @Column(name = "Description")
    private String description;

    @OneToOne
    private User user;

    @OneToOne
    private User reviewer;

    public Review(){}

    public Review (long id, long rating, String description, User user, User reviewer){
        this.id = id;
        this.rating = rating;
        this.description = description;
        this.user = user;
        this.reviewer = reviewer;
    }
    public Review (long rating, String description, User user, User reviewer){
        this.rating = rating;
        this.description = description;
        this.user = user;
        this.reviewer = reviewer;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRating() {
        return rating;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getReviewer() {
        return reviewer;
    }

    public void setReviewer(User reviewer) {
        this.reviewer = reviewer;
    }
}
