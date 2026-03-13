package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket {

    private BigDecimal price;
    private LocalDateTime purchaseTime;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(LocalDateTime purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
}