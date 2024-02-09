package ru.project.catsgram.model;

import java.time.Instant;

public class Post implements Comparable<Post> {

    private Integer id;
    private static Integer nextId = 1;
    private final String author;
    private final Instant creationDate = Instant.now();
    private String description;
    private String photoUrl;

    public Post(String author, String description, String photoUrl) {
        this.id = nextId++;
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Post p) {
        if (this.getCreationDate().equals(p.getCreationDate())) {
            return 0;
        }

        if (this.getCreationDate().isBefore(p.getCreationDate())) {
            return -1;
        }

        return 1;
    }
}
