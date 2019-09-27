package com.codeup.silverlining.Model;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private String date;

    @Column(name = "isComplete")
    private boolean isComplete;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "tasks")
    private List<User> workers;

    public Post (){};

    public Post (Post copy){
        id = copy.id;
        title = copy.title;
        body = copy.body;
        user = copy.user;
        workers = copy.workers;
        category = copy.category;
        location = copy.location;
        date = copy.date;
        isComplete = copy.isComplete;
    }

    public Post (long id, String title, String body, List<User> workers, User user, String category, String location ,String date, boolean isComplete){
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
        this.workers = workers;
        this.category = category;
        this.location = location;
        this.date = date;
        this.isComplete = isComplete;
    }
    public Post (String body, String title, User user, List<User> workers, String category, String location, String date, boolean isComplete){
        this.title = title;
        this.body = body;
        this.user = user;
        this.workers = workers;
        this.category = category;
        this.location = location;
        this.date = date;
        this.isComplete = isComplete;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<User> getWorkers() {
        return workers;
    }

    public void setWorkers(List<User> workers) {
        this.workers = workers;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

}
