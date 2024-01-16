package com.devtiro.database.repositories;

import com.devtiro.database.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface  AuthorRepository extends CrudRepository<Author, Long> {
    Iterable<Author> ageLessThan(int age);
}
