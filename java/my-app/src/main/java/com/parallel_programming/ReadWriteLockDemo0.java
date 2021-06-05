/**
 * Several users reading a calendar, but only a few users updating it
 */
package com.parallel_programming;

import java.util.concurrent.locks.*;

class CalendarUser extends Thread {

    private static final String[] WEEKDAYS = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

    private static int today = 4; // 4 = Fri because everybody loves Friday
    private static ReentrantLock marker = new ReentrantLock();

    public CalendarUser(String name) {
        this.setName(name);
    }

    public void run() {
        while (today < WEEKDAYS.length-1){
            if (this.getName().contains("Writer")) { // update the shared calendar
                marker.lock();
                try {
                    today = (today+1) % 7;
                    System.out.println(this.getName() + " updated date to " + WEEKDAYS[today]);
                } catch (Exception e)
                    {e.printStackTrace(); }
                {
                    marker.unlock();
                }
            } else { // Reader - check to see what today is
                marker.lock();
                try {
                    System.out.println(this.getName() + " sees that today is " + WEEKDAYS[today]);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    marker.unlock();
                }
            }
        }
    }
}

public class ReadWriteLockDemo0 {
    public static void main(String[] args) {

        // create ten reader threads
        for (int i=0; i<10; i++)
            new CalendarUser("Reader-"+i).start();

        // ...but only two writer threads
        for (int i=0; i<2; i++)
            new CalendarUser("Writer-"+i).start();
    }
}