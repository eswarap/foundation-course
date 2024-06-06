package org.woven.foundation.course;

import org.junit.jupiter.api.Test;
import org.woven.foundation.course.designpattern.builder.Book;
import org.woven.foundation.course.designpattern.builder.Genre;

import java.time.Year;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBook {

    private static final Logger logger = Logger.getLogger(TestBook.class.getName());

    @Test
    public void testBook() {
        Book book = new Book.Builder("2322","Design Patterns")
                .genre(Genre.NONFICTION)
                .author("John bats")
                .description("Gang of four, Fourth Edition")
                .published(Year.of(2000))
                .build();

        logger.info(book.toString());
        assert book!=null;
        assert book.getTitle().equals("Design Patterns");
        assert !book.getPublished().equals(Year.of(2001));
    }
}
