package com.combinatorpattern;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice",
                "alice@gmail.com",
                "+017979023",
                LocalDate.of(2000, 1,1)
        );

        CustomerValidator validator1 = new CustomerValidator();
        System.out.println(validator1.isValid(customer));

        // we can store the customer in DB



    }




}
