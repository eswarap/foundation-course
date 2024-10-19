package org.woven.foundation.course.collections;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.woven.foundation.course.codechef.Address;

import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode
public class Person implements Comparable<Person> {
    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final Address address;


    public Person(final String firstName, final String lastName, LocalDate dateOfBirth, final Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    @Override
    public int compareTo(final Person o) {
        return this.firstName.compareTo(o.firstName);
    }
}
