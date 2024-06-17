package org.woven.foundation.course.designpattern.builder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Map<String, Map<Genre, List<Book>>> results = books.stream().filter(book -> Genre.NONFICTION.equals(book.getGenre()))
                .collect(groupingBy(Book::getAuthor, groupingBy(Book::getGenre)));
        results.forEach((key,value) -> logger.log(Level.INFO,"{0} : {1}",new Object[]{key,value}));

    }

    @DisplayName("listToMap - Isbn : Title")
    @Test
    void testBookListToMap() {
        Map<String, String> results = books.stream()
                .collect(Collectors.toMap(Book::getIsbn, Book::getTitle));
                
        results.forEach((key,value) -> logger.log(Level.INFO,"Isbn - {0} : Title - {1}",new Object[]{key,value}));
        assertEquals(5, results.size());
    }

    @DisplayName("listToMapWithDupKeyError - Year of Publish ")
    @Test
    void testBookListToMapWithDupKeyError() {
        books.stream()
            .collect(Collectors.toMap(Book::getPublished, Function.identity()))
            .forEach((key,value) -> logger.log(Level.INFO,"Year Of Publish {0} : Book {1}",new Object[]{key,value}));
    }

    @DisplayName("listToMapWithDupKey - Year of Publish")
    @Test
    void testBooklistToMapWithDupKey() {
        books.stream()
            .collect(Collectors.toMap(Book::getPublished, Function.identity(), (existing, replacement) -> existing))
            .forEach((key,value) -> logger.log(Level.INFO,"Year Of Publish {0} : {1}",new Object[]{key,value}));
    }

    @DisplayName("listToMapWithDupKey - Year of publish")
    @Test
    void testBooklistToConcurrentMap() {
        books.stream()
            .collect(Collectors.toMap(Book::getPublished, Function.identity(), (o1, o2) -> o1, ConcurrentHashMap::new))
            .forEach((key,value) -> logger.log(Level.INFO,"Year Of Publish {0} : {1}",new Object[]{key,value}));
    }

    @DisplayName("listToSortedMap - Title")
    @Test
    void testBooklistToSortedMap() {
        books.stream()
            .collect(Collectors.toMap(Book::getTitle, Function.identity(), (o1, o2) -> o1, TreeMap::new))
            .forEach((key,value) -> logger.log(Level.INFO,"Title : {0} : {1}",new Object[]{key,value}));
    }
}
