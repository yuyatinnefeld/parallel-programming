/**
 * Two shoppers adding items to a shared notepad
 */
package com.parallel_programming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Shopper3 extends Thread {

    static int garlicCount = 0;
    static Lock pencil = new ReentrantLock();

    public void run() {
        for (int i=0; i<100_000; i++) {
            pencil.lock();
            garlicCount++;
            pencil.unlock();

            System.out.println(Thread.currentThread().getName() + " is thinking ....");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class MutexDemo1 {
    public static void main(String[] args) throws InterruptedException {
        Thread barron = new Shopper3();
        Thread olivia = new Shopper3();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println("We should buy " + Shopper3.garlicCount + " garlic.");
    }
}