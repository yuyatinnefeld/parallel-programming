/**
 * Two shoppers adding items to a shared notepad
 */

package com.parallel_programming;


class Shopper5 extends Thread {

    static int garlicCount = 0;

    private static synchronized void addGarlic(){
        garlicCount++;
    }

    public void run() {
        for (int i=0; i<10_000_000; i++)
            addGarlic();
    }
}

public class SynchronizedMethodDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread barron = new Shopper5();
        Thread olivia = new Shopper5();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println("We should buy " + Shopper5.garlicCount + " garlic.");
    }
}