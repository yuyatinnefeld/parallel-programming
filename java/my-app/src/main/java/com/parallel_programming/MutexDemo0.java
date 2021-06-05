/**
 * Two shoppers adding items to a shared notepad
 */
package com.parallel_programming;

import java.util.concurrent.locks.*;

class Shopper2 extends Thread {

    static int garlicCount = 0;
    static Lock pencil = new ReentrantLock();

    public void run() {
        pencil.lock();
        for (int i=0; i<100_000; i++) {
            garlicCount++;
            System.out.println(Thread.currentThread().getName() + " is thinking ....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pencil.unlock();
    }
}

public class MutexDemo0 {
    public static void main(String[] args) throws InterruptedException {
        Thread barron = new Shopper2();
        Thread olivia = new Shopper2();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println("We should buy " + Shopper2.garlicCount + " garlic.");
    }
}