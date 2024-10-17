package org.woven.foundation.course.collections;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.junit.jupiter.api.*;
import org.woven.foundation.course.codechef.Address;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Log
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPersonCollection {

    Collection<Person> personCollection = new ArrayList<>();
    Set<Person> peopleHashSet = new HashSet<>();
    Set<Person> peopleTreeSet = new TreeSet<>();
    Address personAddress = new Address("123 Main St", "Cityville", "12345");
    LocalDate dateOfBirth = LocalDate.of(2000,1,1);
    Person person1 = new Person("John", "Doe", dateOfBirth, personAddress);
    Person person2 = new Person("Jeff", "Smith", dateOfBirth,  personAddress);
    Person person3 = new Person("Jerry", "Maguire", dateOfBirth,  personAddress);
    Person person4 = new Person("Peter", "Parler", dateOfBirth, personAddress);
    Person person5 = new Person("Tom", "Rich", dateOfBirth, personAddress);

    @BeforeEach
    protected void setUp()  {

        personCollection.add(person1);
        personCollection.add(person2);
        personCollection.add(person3);
        personCollection.add(person4);
        personCollection.add(person5);

        peopleHashSet.add(person1);
        peopleHashSet.add(person2);
        peopleHashSet.add(person3);
        peopleHashSet.add(person4);
        peopleHashSet.add(person5);

        peopleTreeSet.add(person1);
        peopleTreeSet.add(person2);
        peopleTreeSet.add(person3);
        peopleTreeSet.add(person4);
        peopleTreeSet.add(person5);
    }

    @AfterEach
    void tearDown() {
        personCollection.clear();
        peopleHashSet.clear();
        peopleTreeSet.clear();
    }

    @Test
    @Order(1)
    @SneakyThrows
    public void testAddPerson_Collection() throws Exception {
        assert personCollection.contains(person1);
        assert personCollection.contains(person2);
        assert personCollection.contains(person3);
        assert personCollection.contains(person4);
        assert personCollection.contains(person5);

        personCollection.forEach(System.out::println);
    }

    @Test
    @Order(2)
    @SneakyThrows
    public void testAddPerson_HashSet() throws Exception {
        assert peopleHashSet.contains(person1);
        assert peopleHashSet.contains(person2);
        assert peopleHashSet.contains(person3);
        assert peopleHashSet.contains(person4);
        assert peopleHashSet.contains(person5);
        assert !peopleHashSet.add(person1);
        peopleHashSet.forEach(System.out::println);
    }

    @Test
    @Order(3)
    @SneakyThrows
    public void testAddPerson_TreeSet() throws Exception {
        assert peopleTreeSet.contains(person1);
        assert peopleTreeSet.contains(person2);
        assert peopleTreeSet.contains(person3);
        assert peopleTreeSet.contains(person4);
        assert peopleTreeSet.contains(person5);
        peopleTreeSet.forEach(System.out::println);
    }


    @Test
    @Order(4)
    public void testDeletePerson_Collection() throws Exception {

        assert personCollection.contains(person1);
        personCollection.remove(person1);
        assert !personCollection.contains(person1);
    }

    @Test
    @Order(5)
    public void testDeletePerson_HashSet() throws Exception {

        assert peopleHashSet.contains(person1);
        peopleHashSet.remove(person1);
        assert !peopleHashSet.contains(person1);
    }

    @Test
    @Order(6)
    public void testDeletePerson_TreeSet() throws Exception {

        assert peopleTreeSet.contains(person1);
        peopleTreeSet.remove(person1);
        assert !peopleTreeSet.contains(person1);
    }

    @Test
    @Order(0)
    public void testTotalPersons() throws Exception {
        assert personCollection.size() == 5;
    }

}
