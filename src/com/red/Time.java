package com.red;

/**
 * Created by _red_ on 09.06.17.
 */
class Time extends Thread{
    private Chronometr chronometrThread;
    private long interval;
    private long passed;

    @Override
    public void run() {
        while( true ) {
            long seconds = this.chronometrThread.secondsPassed();
            if ((seconds - passed) >= interval) {
                System.out.println("Passed - " + this.interval + " seconds");
                passed = seconds;
            }
        }
    }

    public Time(Chronometr time, long interval) {
        this.chronometrThread = time;
        this.interval = interval;
        this.passed = 0;
    }
}
