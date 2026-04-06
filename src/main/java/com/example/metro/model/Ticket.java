package main.java.com.example.metro.model;

import main.java.com.example.metro.enums.TicketType;
import main.java.com.example.metro.interfaces.Bookable;
import main.java.com.example.metro.interfaces.Payable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket implements Bookable, Payable {

    private BigDecimal price;
    private LocalDateTime purchaseTime;
    private boolean available = true;
    ;

    @Override
    public void book() {
        this.available = false;
        System.out.println("Ticket booked for price: " + price);
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public BigDecimal getAmount() {
        return price != null ? price : BigDecimal.ZERO;
    }

    @Override
    public void processPayment() {
        System.out.println("Processing payment of: " + price);
    }

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

    private TicketType ticketType;

    public TicketType getTicketType() { return ticketType; }
    public void setTicketType(TicketType ticketType) { this.ticketType = ticketType; }
}