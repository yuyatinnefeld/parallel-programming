/**
 * Two shoppers adding garlic and potatoes to a shared notepad
 */
package com.parallel_programming;

import java.util.concurrent.locks.*;

class Shopper7 extends Thread {

    static int garlicCount, potatoCount = 0;
    static ReentrantLock pencil = new ReentrantLock();

    private void addGarlic() {
        pencil.lock();
        System.out.println("Hold count: " + pencil.getHoldCount());
        garlicCount++;
        pencil.unlock();
    }

    private void addPotato() {
        pencil.lock();
        potatoCount++;
        addGarlic();
        pencil.unlock();
    }

    public void run() {
        for (int i=0; i<10_000; i++) {
            addGarlic();
            addPotato();
        }
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread barron = new Shopper7();
        Thread olivia = new Shopper7();
        barron.start();
        olivia.start();
        barron.join();
        olivia.join();
        System.out.println("We should buy " + Shopper7.garlicCount + " garlic.");
        System.out.println("We should buy " + Shopper7.potatoCount + " potatoes.");
    }
}