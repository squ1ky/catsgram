package ru.project.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.project.catsgram.exceptions.IncorrectParameterException;
import ru.project.catsgram.exceptions.PostNotFoundException;
import ru.project.catsgram.model.Post;
import ru.project.catsgram.service.PostService;
import ru.project.catsgram.exceptions.InvalidPageOrSize;

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
    public List<Post> findAll (
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size) throws InvalidPageOrSize, IncorrectParameterException {
        logger.debug("Текущее количество постов: " + postService.getPosts().size());
        if (sort == null || page == null || size == null) {
            if (sort == null) {
                sort = "desc";
            }
            if (page == null) {
                page = 1;
            }
            if (size == null) {
                size = 1;
            }
        }
        if (!sort.equals("asc") && !sort.equals("desc")) {
            throw new IncorrectParameterException("sort");
        }
        if (page <= 0) {
            throw new IncorrectParameterException("page");
        }
        if (size <= 0) {
            throw new IncorrectParameterException("size");
        }
        // Должен быть хотя бы 1 пост
        return postService.findAll(sort, page, size);
    }

    @GetMapping("/posts/{postId}")
    public Post findById(@PathVariable int postId) throws PostNotFoundException {
        List<Post> posts = postService.getPosts();
        for (Post post : posts) {
            if (post.getId() == postId) {
                return post;
            }
        }

        throw new PostNotFoundException("");
    }

    @PostMapping(value = "/post")
    public Post create(@RequestBody Post post) {
        logger.info("Добавлен новый пост by: " + post.getAuthor());
        return postService.create(post);
    }

}
