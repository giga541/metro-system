package main.java.com.example.metro.interfaces;

import java.math.BigDecimal;

public interface Payable {

    void processPayment();

    BigDecimal getAmount();
}