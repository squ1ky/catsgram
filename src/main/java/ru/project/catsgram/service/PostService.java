package ru.project.catsgram.service;

import org.springframework.stereotype.Service;

import ru.project.catsgram.model.Post;

import java.util.List;
import java.util.ArrayList;


@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();
    public List<Post> findAll() {
        return posts;
    }

    public Post create(Post post) {
        posts.add(post);
        return post;
    }

    public List<Post> getPosts() {
        return posts;
    }

}
