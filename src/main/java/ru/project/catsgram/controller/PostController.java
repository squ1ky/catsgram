package ru.project.catsgram.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.project.catsgram.model.Post;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);

    private List<Post> posts = new ArrayList<>();

    @GetMapping("/posts")
    public List<Post> findAll() {
        logger.debug("Текущее количество постов: " + posts.size());
        return posts;
    }

    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {
        posts.add(post);
        logger.info("Добавлен новый пост by: " + post.getAuthor());
        return post;
    }
}
