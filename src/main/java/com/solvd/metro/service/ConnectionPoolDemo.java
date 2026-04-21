package com.solvd.metro.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConnectionPoolDemo {

    private static final Logger logger = LogManager.getLogger(ConnectionPoolDemo.class);

    public static void run() throws InterruptedException {

        ConnectionPool pool = ConnectionPool.getInstance(5);

        ExecutorService executor = Executors.newFixedThreadPool(7);

        // submit 7 tasks
        // 5 will get connection immediately
        // 2 will wait because pool only has 5 connections
        for (int i = 1; i <= 7; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    logger.info("Task {} trying to get connection...", taskId);

                    Connection connection = pool.getConnection();

                    AccountDao dao = new AccountDao(connection);
                    dao.create("Account-" + taskId);
                    dao.get(taskId);
                    dao.update(taskId, "UpdatedName-" + taskId);
                    dao.delete(taskId);

                    Thread.sleep(2000);

                    pool.releaseConnection(connection);

                } catch (InterruptedException e) {
                    logger.error("Task {} interrupted: {}", taskId, e.getMessage());
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(60, TimeUnit.SECONDS);
        logger.info("All tasks completed. Available connections: {}", pool.getAvailableConnections());
    }
}