package com.samsung.repository;

import com.samsung.domain.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class AuthorRepositoryTest {


    @Autowired
    private AuthorRepository authorRepository;

    @DisplayName("Должен добавлять автора")
    @Test
    void shouldInsertAuthor() {

        Author expectedAuthor = Author.builder().id(4).name("Олег").build();
        authorRepository.save(expectedAuthor);
        Author actualAuthor = authorRepository.getById(4);
        assertThat(actualAuthor).isEqualTo(expectedAuthor);
    }



}