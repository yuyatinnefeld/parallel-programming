package com.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        System.out.println(getDBConnectionURL());
        System.out.println(getDBConnectionURLSupplier.get());

    }

    static String getDBConnectionURL(){
        return "jdbc://localhost:5432/users";
    }

    static Supplier<String> getDBConnectionURLSupplier = () -> "jdbc://localhost:5432/users";


}
