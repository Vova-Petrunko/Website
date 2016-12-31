package com.albums.Entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Вова on 30.12.2016.
 */
@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private User author;

    @NotBlank
    @Size(min = 3, max = 30)
    private String title;

    @NotBlank
    private String src;

    private String description;

    public Album() {
    }

    public Album(User author, String title, String src, String description) {
        this.author = author;
        this.title = title;
        this.src = src;
        this.description=description;
    }

    public Album(String author, String title, String src, String description) {
        this.author.setLogin(author);
        this.title = title;
        this.src = src;
        this.description=description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
