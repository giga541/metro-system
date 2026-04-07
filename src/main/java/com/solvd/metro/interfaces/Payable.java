package com.solvd.metro.interfaces;

import java.math.BigDecimal;

public interface Payable {

    void processPayment();

    BigDecimal getAmount();
}