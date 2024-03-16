package ru.project.catsgram.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Post implements Comparable<Post> {

    @Setter
    private Integer id;
    private final User author;
    private final LocalDate creationDate;
    @Setter
    private String description;
    @Setter
    private String photoUrl;

    public Post(User author, String description, String photoUrl) {
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
        this.creationDate = LocalDate.now();
    }

    public Post(Integer id, User author, String description, String photoUrl,
                LocalDate creationDate) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.photoUrl = photoUrl;
        this.creationDate = creationDate;
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
