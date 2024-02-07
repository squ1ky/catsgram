package ru.project.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.project.catsgram.model.Post;
import ru.project.catsgram.service.PostService;

import java.util.Optional;
import java.util.List;


@RestController
public class PostController {

    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> findAll() {
        logger.debug("Текущее количество постов: " + postService.getPosts().size());
        return postService.findAll();
    }

    @GetMapping("/posts/{postId}")
    public Optional<Post> findById(@PathVariable Integer postId) {
        return postService.getPosts().stream()
                .filter(x -> x.getId().equals(postId))
                .findFirst();
    }

    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {
        logger.info("Добавлен новый пост by: " + post.getAuthor());
        return postService.create(post);
    }

}
