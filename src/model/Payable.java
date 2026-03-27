package model;

import java.math.BigDecimal;

public interface Payable {

    void processPayment();

    BigDecimal getAmount();
}