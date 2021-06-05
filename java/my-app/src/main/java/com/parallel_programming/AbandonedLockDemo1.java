/**
 * Three Philosopher3s, thinking and eating sushi
 */
package com.parallel_programming;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Philosopher3 extends Thread {

    private Lock firstChopstick, secondChopstick;
    private static int sushiCount = 500;

    public Philosopher3(String name, Lock firstChopstick, Lock secondChopstick) {
        this.setName(name);
        this.firstChopstick = firstChopstick;
        this.secondChopstick = secondChopstick;
    }

    public void run() {
        while(sushiCount > 0) { // eat sushi until it's all gone

            // pick up chopsticks
            firstChopstick.lock();
            secondChopstick.lock();

            try {
                // take a piece of sushi
                if (sushiCount > 0) {
                    sushiCount--;
                    System.out.println(this.getName() + " took a piece! Sushi remaining: " + sushiCount);
                }

                if(sushiCount == 10){
                    System.out.println("program crush!");
                    System.out.println(1 / 0);
                }
            }
            finally {
                // put down chopsticks
                secondChopstick.unlock();
                firstChopstick.unlock();
            }
        }
    }
}

public class AbandonedLockDemo1 {
    public static void main(String[] args) {
        Lock chopstickA = new ReentrantLock();
        Lock chopstickB = new ReentrantLock();
        Lock chopstickC = new ReentrantLock();
        new Philosopher3("Barron", chopstickA, chopstickB).start();
        new Philosopher3("Olivia", chopstickB, chopstickC).start();
        new Philosopher3("Steve", chopstickA, chopstickC).start();
    }
}