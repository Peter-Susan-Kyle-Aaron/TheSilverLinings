package com.codeup.silverlining.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Users")
public class User {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, name = "username", unique = true)
    private String username;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "email", unique = true)
    private String email;

    @Column(name = "photo")
    private String photo;

    @Column(name = "address")
    private String address;

    @Column(nullable = false, name = "role")
    private long role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="posts_workers",
            joinColumns = @JoinColumn(name="worker_id"),
            inverseJoinColumns= @JoinColumn(name="post_id")
    )
    private List<Post> tasks;

    public User(){};

    public User(String username, String password, String email, String photo, String address, long role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.photo = photo;
        this.address = address;
        this.role = role;
    }
    public User(long id, String username, String password, String email, String photo, String address, long role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.photo = photo;
        this.address = address;
        this.role = role;
    }
    public User(User copy) {
        id = copy.id;
        username = copy.username;
        password = copy.password;
        email = copy.email;
        photo = copy.photo;
        address = copy.address;
        role = copy.role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.tasks = posts;
    }

    public List<Post> getTasks() {
        return tasks;
    }

    public void setTasks(List<Post> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Post task) {
        this.tasks.add(task);
    }

    public void removeTask(Post task) {
        this.tasks.remove(task);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", tasks=" + tasks +
                '}';
    }
}

