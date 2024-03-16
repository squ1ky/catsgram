package ru.project.catsgram.service;

import org.springframework.stereotype.Service;

import ru.project.catsgram.exceptions.UserNotFoundException;
import ru.project.catsgram.model.Post;
import ru.project.catsgram.model.User;
import ru.project.catsgram.dao.PostDao;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostDao postDao;
    private final UserService userService;


    public PostService(PostDao postDao, UserService userService) {
        this.postDao = postDao;
        this.userService = userService;
    }

    public Collection<Post> findPostsByUser(String userId) throws UserNotFoundException {
        User user = userService.findUserById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        return postDao.findPostsByUser(user);
    }

    public Collection<Post> findPostsByUser(String authorId, Integer size, String sort)
        throws UserNotFoundException {
        return findPostsByUser(authorId)
                .stream()
                .sorted((p0, p1) -> {
                    int comp = p0.getCreationDate().compareTo(p1.getCreationDate());
                    if (sort.equals("desc")) {
                        comp = -1 * comp;
                    }
                    return comp;
                })
                .limit(size)
                .collect(Collectors.toList());
    }
}
