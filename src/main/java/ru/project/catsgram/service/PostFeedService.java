package ru.project.catsgram.service;

import org.springframework.stereotype.Service;

import java.util.List;

import ru.project.catsgram.controller.PostFeedController.FriendsPostRequest;
import ru.project.catsgram.model.Post;
import ru.project.catsgram.service.PostService;


@Service
public class PostFeedService {

    private final PostService postService;

    public PostFeedService(PostService postService) {
        this.postService = postService;
    }

    public List<Post> getFriendsPost(FriendsPostRequest request) {
        List<String> friends = request.getFriendsEmails();
        String sort = request.getSort();
        int size = request.getSize();

        return postService.getPostsOfFriends(friends, sort, size);
    }
}
