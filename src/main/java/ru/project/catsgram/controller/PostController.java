package ru.project.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

import ru.project.catsgram.exceptions.UserNotFoundException;
import ru.project.catsgram.model.Post;
import ru.project.catsgram.service.PostService;

@RestController
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public Collection<Post> findAll(@RequestParam String userId) throws UserNotFoundException {
        return postService.findPostsByUser(userId);
    }
}
