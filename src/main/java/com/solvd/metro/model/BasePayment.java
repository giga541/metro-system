package com.solvd.metro.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BasePayment {

    private BigDecimal amount;
    private LocalDateTime paymentDate;

    public BigDecimal getAmountValue() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}