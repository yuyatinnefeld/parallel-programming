/**
 * Two threads chopping vegetables
 */
package com.parallel_programming;


class VegetableChopper extends Thread{

    public int vegetable_count = 0;
    public static boolean chopping = true;

    public VegetableChopper(String name) {
        this.setName(name);
    }

    public void run() {
        while(chopping) {
            System.out.println(this.getName() + " chopped a vegetable!");
            vegetable_count++;
        }
    }
}

public class ExecutionSchedulingDemo {
    public static void main(String args[]) throws InterruptedException {
        VegetableChopper yu = new VegetableChopper("Yu");
        VegetableChopper hana = new VegetableChopper("Mi");

        yu.start();                        // Yu start chopping
        hana.start();                    // hana start chopping
        Thread.sleep(1000);          // continue chopping for 1 second
        VegetableChopper.chopping = false; // stop chopping

        yu.join();
        hana.join();
        System.out.format("Yu chopped %d vegetables.\n", yu.vegetable_count);
        System.out.format("Hana chopped %d vegetables.\n", hana.vegetable_count);
    }
}