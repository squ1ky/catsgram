package ru.project.catsgram.dao;

import ru.project.catsgram.model.Post;

import java.util.List;


public interface FollowDao {
    List<Post> getFollowFeed(String userId, int max);
}
