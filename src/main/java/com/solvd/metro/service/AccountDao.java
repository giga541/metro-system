package com.solvd.metro.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AccountDao {

    private static final Logger logger = LogManager.getLogger(AccountDao.class);

    private final Connection connection;

    public AccountDao(Connection connection) {
        this.connection = connection;
    }

    public void create(String name) {
        logger.info("[{}] Creating account: {}", connection, name);
    }

    public void get(int id) {
        logger.info("[{}] Getting account with id: {}", connection, id);
    }

    public void update(int id, String name) {
        logger.info("[{}] Updating account id: {} with name: {}", connection, id, name);
    }

    public void delete(int id) {
        logger.info("[{}] Deleting account with id: {}", connection, id);
    }
}