package com.optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Object val1 = Optional.ofNullable(null)
                .orElseGet(() -> "default value");

        Object val2 = Optional.ofNullable("halloooo")
                .orElseGet(() -> "default value");

        System.out.println(val1);
        System.out.println(val2);

        Optional.ofNullable("heyo@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email));



    }

}
