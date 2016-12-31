package com.albums.Entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вова on 30.12.2016.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @Size(min = 1, max = 512)
    @Column(unique = true)
    private String login;

    @NotBlank
    @Size(min = 1, max = 512)
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 1, max = 100)
    private String password;

    @OneToMany(mappedBy = "author")
    private List<Album> albums = new ArrayList<>();

    public User() {
        super();
    }

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
