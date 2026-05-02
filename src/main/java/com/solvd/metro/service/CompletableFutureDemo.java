package com.solvd.metro.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    private static final Logger logger = LogManager.getLogger(CompletableFutureDemo.class);

    public static void run() throws ExecutionException, InterruptedException {

        // 1. simple CompletableFuture - no CompletionStage
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            logger.info("Future 1: fetching train status...");
            return "Train 101 is ACTIVE";
        });
        logger.info("Future 1 result: {}", future1.get());

        // 2. thenApply - transform result (CompletionStage)
        CompletableFuture<String> future2 = CompletableFuture
                .supplyAsync(() -> "Train 102")
                .thenApply(train -> {
                    logger.info("Future 2: processing {}", train);
                    return train + " is MAINTENANCE";
                });
        logger.info("Future 2 result: {}", future2.get());

        // 3. thenAccept - consume result without returning (CompletionStage)
        CompletableFuture<Void> future3 = CompletableFuture
                .supplyAsync(() -> "Passenger Giga")
                .thenAccept(passenger -> logger.info("Future 3: boarding {}", passenger));
        future3.get();

        // 4. thenCombine - combine two futures (CompletionStage)
        CompletableFuture<String> trainFuture = CompletableFuture
                .supplyAsync(() -> "Train 101");
        CompletableFuture<String> stationFuture = CompletableFuture
                .supplyAsync(() -> "Central Station");
        CompletableFuture<String> future4 = trainFuture
                .thenCombine(stationFuture, (train, station) -> {
                    logger.info("Future 4: combining {} and {}", train, station);
                    return train + " arriving at " + station;
                });
        logger.info("Future 4 result: {}", future4.get());

        // 5. exceptionally - handle errors (CompletionStage)
        CompletableFuture<String> future5 = CompletableFuture
                .<String>supplyAsync(() -> {
                    logger.info("Future 5: simulating error...");
                    throw new RuntimeException("Connection failed!");
                })
                .exceptionally(ex -> {
                    logger.error("Future 5: caught error: {}", ex.getMessage());
                    return "Default connection used instead";
                });
        logger.info("Future 5 result: {}", future5.get());
    }
}