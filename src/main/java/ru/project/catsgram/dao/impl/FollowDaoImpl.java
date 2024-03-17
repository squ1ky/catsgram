package ru.project.catsgram.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import ru.project.catsgram.dao.FollowDao;
import ru.project.catsgram.dao.*;
import ru.project.catsgram.model.Post;
import ru.project.catsgram.model.User;
import ru.project.catsgram.model.Follow;

import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;


@Component
public class FollowDaoImpl implements FollowDao {

    private final JdbcTemplate jdbcTemplate;
    private final UserDao userDao;
    private final PostDao postDao;


    public FollowDaoImpl(JdbcTemplate jdbcTemplate, UserDao userDao, PostDao postDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
        this.postDao = postDao;
    }

    @Override
    public List<Post> getFollowFeed(String userId, int max) {
        String sql = "select * from cat_follow where user_id = ? limit (?)";
        List<Follow> follows = jdbcTemplate.query(sql, (rs, rowNum) -> makeFollow(rs), userId, max);

        Set<User> authors = new HashSet<>();

        for (Follow follow : follows) {
            Optional<User> followOptionalUser = userDao.findUserById(follow.getFollowId());
            if (followOptionalUser.isPresent()) {
                User followUser = followOptionalUser.get();
                authors.add(followUser);
            }
        }

        List<Post> followFeed = new ArrayList<>(max);
        for (User author : authors) {
            Collection<Post> postsOfUser = postDao.findPostsByUser(author);
            followFeed.addAll(postsOfUser);
        }

        return followFeed;
    }

    private Follow makeFollow(ResultSet rs) throws SQLException {

        String userId = rs.getString("user_id");
        String followId = rs.getString("follow_id");

        return new Follow(userId, followId);
    }
}
