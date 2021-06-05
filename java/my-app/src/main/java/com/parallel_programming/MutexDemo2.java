/**
 * Two shoppers adding items to a shared notepad
 */
package com.parallel_programming;
import java.util.concurrent.atomic.*;

class Shopper4 extends Thread {

    static AtomicInteger garlicCount = new AtomicInteger(0);

    public void run() {
        for (int i = 0; i < 100_000; i++)
            garlicCount.incrementAndGet();
    }
}

public class MutexDemo2 {
    public static void main(String[] args) throws InterruptedException {
        Thread barron = new Shopper4();
        Thread olivia = new Shopper4();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println("We should buy " + Shopper4.garlicCount + " garlic.");
    }
}