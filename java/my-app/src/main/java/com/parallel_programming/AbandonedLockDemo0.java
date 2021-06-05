/**
 * Three Philosopher2s, thinking and eating sushi
 */
package com.parallel_programming;

import java.util.concurrent.locks.*;

class Philosopher2 extends Thread {

    private Lock firstChopstick, secondChopstick;
    private static int sushiCount = 500;

    public Philosopher2(String name, Lock firstChopstick, Lock secondChopstick) {
        this.setName(name);
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        while(sushiCount > 0) { // eat sushi until it's all gone

            // pick up chopsticks
            firstChopstick.lock();
            secondChopstick.lock();

            // take a piece of sushi
            if (sushiCount > 0) {
                sushiCount--;
                System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
            }

            if(sushiCount == 10)
                System.out.println("program crush!");
                System.out.println(1/0);

            // put down chopsticks
            secondChopstick.unlock();
            firstChopstick.unlock();
        }
    }
}

public class AbandonedLockDemo0 {
    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        new Philosopher2("Barron", chopstickA, chopstickB).start();
        new Philosopher2("Olivia", chopstickB, chopstickC).start();
        new Philosopher2("Steve", chopstickA, chopstickC).start();
    }
}