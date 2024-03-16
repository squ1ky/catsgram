package ru.project.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

import ru.project.catsgram.exceptions.UserNotFoundException;
import ru.project.catsgram.model.Post;
import ru.project.catsgram.service.PostService;

import java.util.Collection;


@RestController
public class PostFeedController {

    private final PostService postService;

    @Autowired
    public PostFeedController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/feed/friends")
    public Collection<Post> findPostsByUser(@RequestParam String authorId, @RequestParam Integer size,
                                      @RequestParam String sort) throws UserNotFoundException {
        return postService.findPostsByUser(authorId, size, sort);
    }

}
