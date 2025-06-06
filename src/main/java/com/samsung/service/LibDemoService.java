package com.samsung.service;

import com.samsung.domain.Author;
import com.samsung.domain.Book;
import com.samsung.domain.Comment;
import com.samsung.repository.AuthorRepository;
import com.samsung.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibDemoService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public void authorDemo(){
        List<Author> authors = authorRepository.findAll();
        System.out.println("============");
        for(Author author : authors){
            System.out.println(author);
        }
        Author author = Author.builder()
                .name("Иван")
                .build();
        authorRepository.save(author);

        List<Author> author1s = authorRepository.findAll();
        System.out.println("============");
        for(Author author1 : author1s){
            System.out.println(author1);
        }

    }

    @Transactional
    public void bookDemo(){
        List<Book> books = bookRepository.findAll();


        for(Book book : books){
            System.out.println(book.getName()+ ":");
            System.out.println(book.getAuthor()+ ",");

            System.out.println(book.getGenre()+ ",");
            List<Comment> comments = book.getComments();

            for(Comment comment : comments){
                System.out.println(comment.getContent());
            }

        }
    }
}
