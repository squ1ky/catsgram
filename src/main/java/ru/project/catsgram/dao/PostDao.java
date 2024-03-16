package ru.project.catsgram.dao;

import ru.project.catsgram.model.User;
import ru.project.catsgram.model.Post;

import java.util.Collection;

public interface PostDao {

    Collection<Post> findPostsByUser(User user);
}
