package com.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args){
        int increment = increment(1);
        System.out.println(increment);

        //java.util.function.Function => takes 1 argument and produces 1 result
        int increment2 = incrementBy1.apply(1);
        System.out.println(increment2);

        int multiply = multipleBy10.apply(2);
        System.out.println(multiply);

        int result = addBy1AndThenMultiplyBy10.apply(1);
        System.out.println(result);

        //java.util.function.BiFunction => takes 2 argument and produces 1 result
        double result2 = proportionOfTotal.apply(2.0,5.0);
        System.out.println(result2);

    }

    // Standard Style
    static int increment(int num){
        return num +1;
    }

    // Functional Style
    // Function<InputDataType, OutputDataType>
    static  Function<Integer,Integer> incrementBy1 = number -> number + 1;

    static  Function<Integer,Integer> multipleBy10 = number -> number * 10;

    static  Function<Integer, Integer> addBy1AndThenMultiplyBy10 = incrementBy1.andThen(multipleBy10);

    static BiFunction<Double, Double, Double> proportionOfTotal = (input1, input2)
            -> input2 / (input1 + input2) * 100;


}
