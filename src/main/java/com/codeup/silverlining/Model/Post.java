package com.codeup.silverlining.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Posts")
public class Post {
    @Id @GeneratedValue
    private long id;
//
    @Column(name = "Title")
    private String title;

    @Column(name = "Body", length = 5000)
    private String body;

    @Column(name = "Category")
    private String category;

    @Column(nullable = false, name = "Location")
    private String location;

    @Column(name = "Date")
    private long date;

    @OneToOne
    private User user;

    @OneToMany
    private List<User> worker;

    public Post (){};

    public Post (Post copy){
        id = copy.id;
        body = copy.body;
        user = copy.user;
        worker = copy.worker;
        category = copy.category;
        location = copy.location;
        date = copy.date;
    }

    public Post (long id, String title, String body, List<User> worker, User user, String category, String location ,long date){
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.worker = worker;
        this.category = category;
        this.location = location;
        this.date = date;
    }
    public Post (String body, String title, User user, List<User> worker, String category, String location, long date){
        this.title = title;
        this.body = body;
        this.user = user;
        this.worker = worker;
        this.category = category;
        this.location = location;
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public List<User> getWorker() {
        return worker;
    }

    public void setWorker(List<User> worker) {
        this.worker = worker;
    }
}
