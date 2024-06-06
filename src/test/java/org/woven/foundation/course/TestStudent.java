package org.woven.foundation.course;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TestStudent {

    private static final Logger logger = Logger.getLogger(TestStudent.class.getName());

    static List<Student> studentList =  new ArrayList<>();
    @BeforeAll
    static void setup() {
        logger.info("@BeforeAll - executes once before all test methods in this class");
        UUID id = UUID.randomUUID();
        Student s1 = new Student(id,"John", LocalDate.of(1980,8,22),"English",
                BigDecimal.valueOf(70),"Chennai", Gender.BOY);
        Student s2 = new Student(id,"John", LocalDate.of(1980,8,22),"Maths",
                BigDecimal.valueOf(70),"Chennai", Gender.BOY);
        Student s3 = new Student(id,"John", LocalDate.of(1980,8,22),"Chemisty",
                BigDecimal.valueOf(70),"Chennai", Gender.BOY);
        Student s4 = new Student(id,"John", LocalDate.of(1980,8,22),"Biology",
                BigDecimal.valueOf(70),"Chennai", Gender.BOY);
        Student s5 = new Student(id,"John", LocalDate.of(1980,8,22),"Physics",
                BigDecimal.valueOf(70),"Chennai", Gender.BOY);

        id = UUID.randomUUID();
        Student s6 = new Student(id,"Mitchell", LocalDate.of(1981,8,22),"English",
                BigDecimal.valueOf(60),"Bangalore",Gender.GIRL);
        Student s7 = new Student(id,"Mitchell", LocalDate.of(1981,8,22),"Maths",
                BigDecimal.valueOf(60),"Bangalore",Gender.GIRL);
        Student s8 = new Student(id,"Mitchell", LocalDate.of(1981,8,22),"Chemisty",
                BigDecimal.valueOf(60),"Bangalore",Gender.GIRL);
        Student s9 = new Student(id,"Mitchell", LocalDate.of(1981,8,22),"Biology",
                BigDecimal.valueOf(60),"Bangalore",Gender.GIRL);
        Student s10 = new Student(id,"Mitchell", LocalDate.of(1981,8,22),"Physics",
                BigDecimal.valueOf(60),"Bangalore",Gender.GIRL);

        id = UUID.randomUUID();
        Student s11 = new Student(id,"Catherine", LocalDate.of(1998,8,22),"English",
                BigDecimal.valueOf(65),"Pune",Gender.GIRL);
        Student s12 = new Student(id,"Catherine", LocalDate.of(1998,8,22),"Maths",
                BigDecimal.valueOf(65),"Pune",Gender.GIRL);
        Student s13 = new Student(id,"Catherine", LocalDate.of(1998,8,22),"Chemisty",
                BigDecimal.valueOf(65),"Pune",Gender.GIRL);
        Student s14 = new Student(id,"Catherine", LocalDate.of(1998,8,22),"Biology",
                BigDecimal.valueOf(65),"Pune",Gender.GIRL);
        Student s15 = new Student(id,"Catherine", LocalDate.of(1998,8,22),"Physics",
                BigDecimal.valueOf(65),"Pune",Gender.GIRL);

        id = UUID.randomUUID();
        Student s16 = new Student(id,"Joseph", LocalDate.of(2000,8,22),"English",
                BigDecimal.valueOf(78),"Nasik",Gender.BOY);
        Student s17 = new Student(id,"Joseph", LocalDate.of(2000,8,22),"Maths",
                BigDecimal.valueOf(80),"Nasik",Gender.BOY);
        Student s18 = new Student(id,"Joseph", LocalDate.of(2000,8,22),"Physics",
                BigDecimal.valueOf(81),"Nasik",Gender.BOY);
        Student s19 = new Student(id,"Joseph", LocalDate.of(2000,8,22),"Chemisty",
                BigDecimal.valueOf(82),"Nasik",Gender.BOY);
        Student s20 = new Student(id,"Joseph", LocalDate.of(2000,8,22),"Biology",
                BigDecimal.valueOf(89),"Nasik",Gender.BOY);

        id = UUID.randomUUID();
        Student s21 = new Student(id,"Emma", LocalDate.of(1991,8,22),"English",
                BigDecimal.valueOf(90),"Mumbai",Gender.GIRL);
        Student s22 = new Student(id,"Emma", LocalDate.of(1991,8,22),"Maths",
                BigDecimal.valueOf(91),"Mumbai",Gender.GIRL);
        Student s23 = new Student(id,"Emma", LocalDate.of(1991,8,22),"Physics",
                BigDecimal.valueOf(85),"Mumbai",Gender.GIRL);
        Student s24 = new Student(id,"Emma", LocalDate.of(1991,8,22),"Chemisty",
                BigDecimal.valueOf(90),"Mumbai",Gender.GIRL);
        Student s25 = new Student(id,"Emma", LocalDate.of(1991,8,22),"Biology",
                BigDecimal.valueOf(82),"Mumbai",Gender.GIRL);


        studentList = Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17,s18,s19,
                s20,s21,s22,s23,s24,s25);

    }

    @DisplayName("testing groupingby city")
    @Test
    void testGroupingByCity(){
        Map<String, List<Student>> results = studentList.stream().collect(groupingBy(Student::getCity));
        logger.log(Level.INFO,"{0}",results);
    }

    @DisplayName("testing grouping by city , gender and subject")
    @Test
    void testNestedGroupingBy(){
        Map<String, List<Student>> results = studentList.stream().collect(groupingBy(Student::getCity));
        logger.log(Level.INFO,"{0}",results);
    }

    @Test
    void testGroupingByGender(){
        Map<Gender, List<Student>> results = studentList.stream().collect(groupingBy(Student::getGender));
        logger.log(Level.INFO,"{0}",results);
    }

    @Test
    void testGroupingBySubject(){
        Map<String, List<Student>> results = studentList.stream().collect(groupingBy(Student::getSubject));
        logger.log(Level.INFO,"{0}",results);
    }

    @Test
    void testGroupingByAge(){
        Map<Integer, List<Student>> results = studentList.stream().collect(groupingBy(Student::getAge));
        logger.log(Level.INFO,"{0}",results);
    }

    @Test
    void testGroupingByGenderAndSubjectAndCounting(){
        Map<Gender, Map<String, Long>> results = studentList.stream().
                collect(groupingBy(Student::getGender, groupingBy(Student::getSubject, counting())));
        logger.log(Level.INFO,"{0}",results);
    }

    @Test
    void testGroupingBySubjectAndCounting(){
        Map<UUID, Long> results = studentList.stream().collect(groupingBy(Student::getId, counting()));
        logger.log(Level.INFO,"{0}",results);
    }

    @Test
    void testGroupingByAgeAndSubjectAndCounting(){
        var results = studentList.stream().collect(groupingBy(Student::getAge, groupingBy(Student::getSubject,counting())));
        logger.log(Level.INFO,"{0}",results);
    }

    @Test
    void testDuplicate(){
        List<Integer> list = Arrays.asList(1,2,3,2,2,3,4,2,5,8,6,2);
//        var results = list.stream().collect(groupingBy(Function.identity(),counting()));

        var results = list.stream().filter(integer -> Collections.frequency(list,integer) > 1).collect(Collectors.toSet());
        logger.log(Level.INFO,"{0}",results);
    }

}
