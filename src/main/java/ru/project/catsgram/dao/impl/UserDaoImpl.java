package ru.project.catsgram.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import ru.project.catsgram.dao.UserDao;
import ru.project.catsgram.model.User;

import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findUserById(String id) {
        SqlRowSet userRows = jdbcTemplate.queryForRowSet("select * from cat_user where id = ?", id);
        User user = new User();
        user.setId(id);
        return Optional.of(user);
    }
}
