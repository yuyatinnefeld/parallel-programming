package com.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        Customer tanaka = new Customer("tanaka", "0178142397");

        //Standard Approach
        greetCustomer(tanaka);

        //Consumer Functional Approach
        greetCustomerConsumer.accept(tanaka);
        greetCustomerConsumerV2.accept(tanaka, true);
        greetCustomerConsumerV2.accept(tanaka, false);

    }

    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName
                + ", thanks for registering phone number: " + customer.customerPhoneNumber);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName
                    + ", thanks for registering phone number: " + customer.customerPhoneNumber);

    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
            System.out.println("Hello " + customer.customerName
                    + ", thanks for registering phone number: "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "*************"));

    static class Customer{
        private final String customerName;
        private final String customerPhoneNumber;

        public Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }

}
