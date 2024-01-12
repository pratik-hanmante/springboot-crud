package com.devtiro.database.dao.impl;

import com.devtiro.database.dao.impl.AuthorDaoImpl;
import com.devtiro.database.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AuthorDaoImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;
//    denotest jdbctemplate is a mockito mock object, stimulate the
    //behavior of the real objects but dont execute real code

    @InjectMocks
    private AuthorDaoImpl underTest;

//    @InjectMocks: Specifies that the AuthorDaoImpl instance (underTest) should be injected with the mocked objects.

    @Test
    public void testThatCreateAuthorGeneratesCorrectSql() {
        Author author = Author.builder()
                .id(1L)
                .name("Abigail Rose")
                .age(80)
                .build();

        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO authors (id, name, age) VALUES (?,?,?)")),
                eq(1L),eq("Abigail Rose"), eq(80)
        );


    }

    @Test
    public void
}
