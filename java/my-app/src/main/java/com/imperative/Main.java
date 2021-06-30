package com.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        List<Person> people = new ArrayList<>();

        people.add(new Person("John", Gender.MALE));
        people.add(new Person("Maria", Gender.FEMALE));
        people.add(new Person("Aisha", Gender.FEMALE));
        people.add(new Person("Alex", Gender.MALE));
        people.add(new Person("Alice", Gender.FEMALE));


        List<Person> females = new ArrayList<>();
        List<Person> males = new ArrayList<>();

        for(Person person: people){
            if(Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        System.out.println("### Imperative approach ###");
        System.out.println("Female List:");
        for (Person female : females){
            System.out.println(female);
        }


        System.out.println("### Declarative approach ###");
        System.out.println("Female List:");

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);

        people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }

    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender){
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE, FEMALE
    }

}
