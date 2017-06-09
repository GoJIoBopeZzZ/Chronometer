package com.red;

public class Main {

    public static void main(String[] args) {
        Chronometr chronoThread = new Chronometr(System.currentTimeMillis());
        Time firstInterval = new Time(chronoThread, 5);
        Time secondInterval = new Time(chronoThread, 7);
        chronoThread.start();
        firstInterval.start();
        secondInterval.start();
    }
}