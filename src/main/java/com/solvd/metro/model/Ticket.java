package com.solvd.metro.model;

import com.solvd.metro.enums.TicketType;
import com.solvd.metro.interfaces.Bookable;
import com.solvd.metro.interfaces.Payable;
import com.solvd.metro.service.Booking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ticket implements Bookable, Payable {

    private static final Logger logger = LogManager.getLogger(Ticket.class);

    private BigDecimal price;
    private LocalDateTime purchaseTime;
    private boolean available = true;
    ;

    @Override
    public void book() {
        this.available = false;
        logger.info("Ticket booked for price: {}", price);
    }

    @Override
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) { this.available = available; }

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

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
}