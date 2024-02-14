package ru.project.catsgram.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;

import ru.project.catsgram.service.PostFeedService;
import ru.project.catsgram.model.Post;

import java.util.List;
import java.io.IOException;

@RestController
public class PostFeedController {

    private final PostFeedService postFeedService;
    private final ObjectMapper objectMapper;

    @Autowired
    public PostFeedController(PostFeedService postService, ObjectMapper objectMapper) {
        this.postFeedService = postService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/feed/friends")
    public List<Post> getFriendsPost(@RequestBody String requestBody) throws IOException {
        FriendsPostRequest friendsPostRequest = objectMapper.readValue(requestBody, FriendsPostRequest.class);
        return postFeedService.getFriendsPost(friendsPostRequest);
    }

    public static class FriendsPostRequest {
        private String sort;
        private int size;
        private List<String> friendsEmails;

        public String getSort() {
            return sort;
        }

        public int getSize() {
            return size;
        }

        public List<String> getFriendsEmails() {
            return friendsEmails;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public void setFriendsEmails(List<String> friendsEmails) {
            this.friendsEmails = friendsEmails;
        }
    }
}
