package com.red;

/**
 * Created by _red_ on 09.06.17.
 */
public class Chronometr extends Thread{
    private long startMillis;
    private long secPassed;

    @Override
    public void run() {
        long currMillis;
        try {
            while (true) {
                Thread.sleep(1000);
                currMillis = System.currentTimeMillis();
                this.secPassed = (currMillis - startMillis) / 1000;
                this.notifySecondsPassed();
                System.out.println(secPassed);
            }
        }
        catch (InterruptedException ex) { }
    }

    public Chronometr(long startMillis) {
        this.startMillis = startMillis;
    }

    synchronized long secondsPassed() {
        try {
            wait();
        }
        catch (InterruptedException ex) {
            System.exit(-1);
        }
        return secPassed;
    }

    synchronized void notifySecondsPassed() {
        notifyAll();
    }
}
