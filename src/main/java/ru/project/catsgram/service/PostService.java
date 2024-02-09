package ru.project.catsgram.service;

import org.springframework.stereotype.Service;

import ru.project.catsgram.exceptions.InvalidPageOrSize;
import ru.project.catsgram.model.Post;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


@Service
public class PostService {

    private final List<Post> posts = new ArrayList<>();

    public List<Post> findAll(String sort, Integer page, Integer size) throws InvalidPageOrSize {
        if (page < 1 || size <= 0) {
            throw new InvalidPageOrSize("Начальный номер поста/Кол-во постов <= 0");
        } else {
            page = page - 1;
            if (sort.equals("asc") || sort.equals("desc")) {
                List<Post> result = new ArrayList<>();
                Collections.sort(posts);
                if (sort.equals("desc")) {
                    Collections.reverse(posts);
                }
                if (page + size <= posts.size()) {
                    return posts.subList(page, page + size);
                } else {
                    throw new InvalidPageOrSize("Страница или кол-во страниц превыщают кол-во постов");
                }
            }
        }

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
