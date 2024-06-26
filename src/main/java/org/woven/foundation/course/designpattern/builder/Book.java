package org.woven.foundation.course.designpattern.builder;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.Year;

@Data
@Getter
@ToString
public class Book {

    private final String isbn;
    private final String title;
    private final Genre genre;
    private final String author;
    private final Year published;
    private final String description;

    private Book(Builder builder) {
        this.isbn = builder.isbn;
        this.title = builder.title;
        this.genre = builder.genre;
        this.author = builder.author;
        this.published = builder.published;
        this.description = builder.description;
    }

    public static class Builder {
        private String isbn;
        private String title;
        private Genre genre;
        private String author;
        private Year published;
        private String description;

        public Builder(String isbn,String title) {
            this.isbn = isbn;
            this.title = title;
        }

        public Builder genre(Genre genre) {
            this.genre = genre;
            return this;
        }
        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder published(Year published) {
            this.published = published;
            return this;
        }
        public Builder description(String description) {
            this.description= description;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
