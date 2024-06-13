package org.woven.foundation.course;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.woven.foundation.course.designpattern.builder.Book;
import org.woven.foundation.course.designpattern.builder.Genre;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class TestBook {

    private static final Logger logger = Logger.getLogger(TestBook.class.getName());

    static List<Book> books =  new ArrayList<>();
    @BeforeAll
    static void setup() {
        Book book = new Book.Builder("2322","Design Patterns")
                .genre(Genre.NONFICTION)
                .author("John bats")
                .description("Gang of four, Fourth Edition")
                .published(Year.of(2000))
                .build();
        books.add(book);
        book = new Book.Builder("5222","Strangers In a Train")
                .genre(Genre.THRILLER)
                .author("Sydney Ramen")
                .description("Paper back, 3rd Edition")
                .published(Year.of(1978))
                .build();
        books.add(book);
        book = new Book.Builder("3522","India-Afpak")
                .genre(Genre.NONFICTION)
                .author("Sushant Sareen")
                .description("A geopolitics primer")
                .published(Year.of(2010))
                .build();
        books.add(book);
        book = new Book.Builder("1420","Russian - Ukraine")
                .genre(Genre.NONFICTION)
                .author("Sushant Sareen")
                .description("A geopolitics primer")
                .published(Year.of(2010))
                .build();
        books.add(book);
        book = new Book.Builder("7920","Microservices")
                .genre(Genre.NONFICTION)
                .author("Sam newman")
                .description("from monolithic to microservices")
                .published(Year.of(2017))
                .build();
        books.add(book);
    }
    @Test
    public void testBook() {
        Book book = new Book.Builder("2322","Design Patterns")
                .genre(Genre.NONFICTION)
                .author("John bats")
                .description("Gang of four, Fourth Edition")
                .published(Year.of(2000))
                .build();

        logger.info(book.toString());
        assert book.getTitle().equals("Design Patterns");
        assert !book.getPublished().equals(Year.of(2001));
    }

    @Test
    void testGenre() {
        books.stream().filter(book -> Genre.NONFICTION.equals(book.getGenre()))
                .toList()
                .forEach(book -> logger.log(Level.INFO,"{0}",book.toString()));
    }

    @Test
    void testAuthorGenre() {
        Map<String, Map<Genre, List<Book>>> results = books.stream().filter(book -> Genre.NONFICTION.equals(book.getGenre()))
                .collect(groupingBy(Book::getAuthor, groupingBy(Book::getGenre)));
        results.forEach((key,value) -> logger.log(Level.INFO,"{0} : {1}",new Object[]{key,value}));
    }

    @Test
    void testAuthorGenreCount() {
        Map<String, Map<Genre, Long>> results = books.stream().filter(book -> Genre.NONFICTION.equals(book.getGenre()))
                .collect(groupingBy(Book::getAuthor, groupingBy(Book::getGenre, Collectors.counting())));
        results.forEach((key,value) -> logger.log(Level.INFO,"{0} : {1}",new Object[]{key,value}));

    }
}
