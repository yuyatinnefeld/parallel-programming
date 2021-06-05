/**
 * Two shoppers adding items to a shared notepad
 */
package com.parallel_programming;

class SmallShopper extends Thread {

    static int garlicCount = 0;

    public void run() {
        for (int i=0; i<10; i++)
            garlicCount++;
    }
}


class Shopper extends Thread {

    static int garlicCount = 0;

    public void run() {
        for (int i=0; i<100_000; i++)
            garlicCount++;
    }
}

public class DataRaceDemo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Expected shopper 10 x 2 = 20 pieces");
        Thread sb = new SmallShopper();
        Thread so = new SmallShopper();
        sb.start();
        so.start();
        sb.join();
        so.join();
        System.out.println("We should buy " + SmallShopper.garlicCount + " garlic.");


        System.out.println("Expected 100000 x 2 = 200000 pieces");
        Thread barron = new Shopper();
        Thread olivia = new Shopper();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println("We should buy " + Shopper.garlicCount + " garlic.");



    }
}