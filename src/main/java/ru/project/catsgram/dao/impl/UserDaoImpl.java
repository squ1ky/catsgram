package ru.project.catsgram.dao.impl;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.project.catsgram.dao.UserDao;
import ru.project.catsgram.model.User;

import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    private final Logger userDaoImplLogger = LoggerFactory.getLogger(UserDaoImpl.class);

    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findUserById(String id) {

        SqlRowSet userRows = jdbcTemplate.queryForRowSet("select * from cat_user where id = ?", id);

        if (userRows.next()) {
            User user = new User(
                    userRows.getString("id"),
                    userRows.getString("username"),
                    userRows.getString("nickname")
            );

            userDaoImplLogger.info("Найден пользователь {} {}", user.getId(), user.getNickname());

            return Optional.of(user);
        } else {

            userDaoImplLogger.info("Пользователь с идентификатором {} не найден.", id);
            return Optional.empty();
        }
    }
}
