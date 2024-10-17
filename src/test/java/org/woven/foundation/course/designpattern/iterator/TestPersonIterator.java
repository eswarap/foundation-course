package org.woven.foundation.course.designpattern.iterator;

import lombok.extern.java.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.woven.foundation.course.codechef.Address;
import org.woven.foundation.course.collections.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Log
public class TestPersonIterator {

    private static Collection<Person> people  = null;
    static Address personAddress = new Address("123 Main St", "Cityville", "12345");
    static LocalDate dateOfBirth = LocalDate.of(2000,1,1);
    static Person person1 = new Person("John", "Doe", dateOfBirth, personAddress);
    static Person person2 = new Person("Jeff", "Smith", dateOfBirth,  personAddress);
    static Person person3 = new Person("Jerry", "Maguire", dateOfBirth,  personAddress);
    static Person person4 = new Person("Peter", "Parler", dateOfBirth, personAddress);
    static Person person5 = new Person("Tom", "Rich", dateOfBirth, personAddress);

    @BeforeEach
    void setUp() {
        log.info("setup");
        people  = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
    }

    @Test
    public void testPersonIterator() {
        people.forEach(person -> log.info(person.toString()));
        people.stream().iterator().forEachRemaining(person -> log.info(person.toString()));

    }

    @AfterEach
    void tearDown() {
        log.info("tear down");
    }
}
