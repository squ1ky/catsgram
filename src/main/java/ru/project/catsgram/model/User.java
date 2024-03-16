package ru.project.catsgram.model;

import lombok.Getter;
import lombok.Setter;

public class User {

    @Getter @Setter
    private String id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String nickname;

    public User() {

    }

    public User(String id, String username, String nickname) {
        this.id = id;
        this.username = username;
        this.nickname = nickname;
    }

}
