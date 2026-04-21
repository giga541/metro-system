package com.solvd.metro.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadDemo {

    private static final Logger logger = LogManager.getLogger(ThreadDemo.class);

    // Thread 1 - using Runnable
    public static class TrainStatusRunnable implements Runnable {

        private final String trainName;

        public TrainStatusRunnable(String trainName) {
            this.trainName = trainName;
        }

        @Override
        public void run() {
            logger.info("Checking status of train: {} on thread: {}", trainName, Thread.currentThread().getName());
        }
    }

    // Thread 2 - using Thread
    public static class PassengerBoardingThread extends Thread {

        private final String passengerName;

        public PassengerBoardingThread(String passengerName) {
            this.passengerName = passengerName;
        }

        @Override
        public void run() {
            logger.info("Passenger {} boarding on thread: {}", passengerName, Thread.currentThread().getName());
        }
    }
}