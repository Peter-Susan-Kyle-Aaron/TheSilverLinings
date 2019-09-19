package com.codeup.silverlining.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Posts")
public class Post {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, name = "Title")
    private String title;

    @Column(nullable = false, name = "Description", length = 5000)
    private String body;

    @Column(nullable = false, name = "Category")
    private  String category;

    @Column(nullable = false, name = "Event_Location")
    private String location;

    @Column(nullable = false, name = "Event_Date")
    private String date;

    @OneToOne
    private User user;

    public Post (){};

    public Post (Post copy){
        id = copy.id;
        title = copy.title;
        body = copy.body;
        user = copy.user;
        category = copy.category;
        location = copy.location;
        date = copy.date;
    }

    public Post (long id, String title, String body, User user, String category, String location ,String date){
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.category = category;
        this.location = location;
        this.date = date;
    }
    public Post (String title, String body, User user, String category, String location, String date){
        this.title = title;
        this.body = body;
        this.user = user;
        this.category = category;
        this.location = location;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEvent_Location() {
        return location;
    }

    public void setEvent_Location(String location) {
        this.location = location;
    }

    public String getEven_Date() {
        return date;
    }

    public void setEvent_Date(String date) {
        this.date = date;
    }
}
