package com.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Stream {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("John", "USA", Gender.MALE, 22));
        people.add(new Person("Maria","UK", Gender.FEMALE, 29));
        people.add(new Person("Aisha","USA", Gender.FEMALE, 30));
        people.add(new Person("Alex", "Germany", Gender.MALE,50));
        people.add(new Person("Alice","USA", Gender.FEMALE, 19));

        System.out.println("Group: Gender");

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Group: Nationality");
        people.stream()
                .map(person -> person.nationality)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("Name Length");
        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        System.out.println("Filtering only Female");
        people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .forEach(System.out::println);

        System.out.println("Sorting by Name");
        people.stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);


        System.out.println("older than 18 check");
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 18);

        System.out.println("all member more than 18: "+allMatch);

        System.out.println("MAX AGE PERSON");
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        });

    }

    static class Person{
        private final String name;
        private final Gender gender;
        private final String nationality;
        private final Integer age;

        Person(String name, String nationality, Gender gender, Integer age){
            this.name = name;
            this.nationality = nationality;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    ", nationality='" + nationality + '\'' +
                    ", age=" + age +
                    '}';
        }
    }



    enum Gender{
        MALE, FEMALE
    }
}
