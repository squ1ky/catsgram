package ru.project.catsgram.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Follow {

    private String userId;
    private String followId;

    public Follow(String userId, String followId) {
        this.userId = userId;
        this.followId = followId;
    }
}
