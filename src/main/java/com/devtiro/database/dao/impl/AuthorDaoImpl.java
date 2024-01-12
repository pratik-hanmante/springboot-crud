package com.devtiro.database.dao.impl;

import com.devtiro.database.dao.AuthorDao;
import com.devtiro.database.domain.Author;
import org.springframework.jdbc.core.JdbcTemplate;


public class AuthorDaoImpl implements AuthorDao {


JdbcTemplate jdbcTemplate = new JdbcTemplate();
    //    its data member of this class
    private final JdbcTemplate jdbcTemplate;

    public AuthorDaoImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void create(Author author) {
        jdbcTemplate.update("INSERT INTO authors(id, name, age) VALUES (?,?,?,?)",
                author.getId(), author.getName(),author.getAge()
                );
    }
}
