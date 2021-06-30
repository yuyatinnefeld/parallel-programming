package com.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {

        List <String> aList = new ArrayList<>();

        aList.add("04900000000");
        aList.add("01200888000");
        aList.add("049000");
        aList.add("04900388800");

        System.out.println("### Standard Approach ###");
        for (String num : aList){
            boolean result = isPhoneNumberValid(num);
            System.out.println("valid: "+result+ " | num: "+num +" | len: "+ num.length());
        }

        System.out.println("### Predicate Functional Approach ###");
        for (String num: aList){
            boolean result2 = isPhoneNumberValidPredicate.test(num);
            System.out.println("valid: "+result2+ " | num: "+num +" | len: "+ num.length());
        }

        for(String num: aList){
            if(isPhoneNumberValidPredicate.and(containsNumber8).test(num)){
                System.out.println(num);
            }
        }
    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("049") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("049") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber8 = phoneNumber -> phoneNumber.contains("888");
}
