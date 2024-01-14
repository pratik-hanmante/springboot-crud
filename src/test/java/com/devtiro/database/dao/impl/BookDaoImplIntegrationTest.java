package com.devtiro.database.dao.impl;

import com.devtiro.database.TestDataUtil;
import com.devtiro.database.dao.AuthorDao;
import com.devtiro.database.domain.Author;
import com.devtiro.database.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {BookDaoImpl.class, AuthorDao.class, JdbcTemplate.class})
@ExtendWith(SpringExtension.class)
public class BookDaoImplIntegrationTest {
    @Autowired
    private  AuthorDao authorDao;

//    reference class to run tests on
    @Autowired
    private final BookDaoImpl underTest ;

//    constructor for the class and autowired injects all necessary dependencies
    @Autowired
    public BookDaoImplIntegrationTest(BookDaoImpl underTest, AuthorDao authorDao) {
        this.underTest = underTest;
        this.authorDao = authorDao;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthor();
//        saving the author
        authorDao.create(author);

//        getting all the data members from the book

        Book book = TestDataUtil.createTestBook();
//        creating book instance for testing
        underTest.create(book);
//        getting isbn
        Optional<Book> result = underTest.find(book.getIsbn());
//        catch and throw like ,checking if the result is present or not
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);
    }

    @Test
    public void testThatFindManyGeneratesCorrectSql() {
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT id")
        )

    }
}
