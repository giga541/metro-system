package model;

import enums.PaymentMethod;
import interfaces.Payable;

import java.math.BigDecimal;

public class Payment extends BasePayment implements Payable {

    private String cardNumber;
    private PaymentMethod paymentMethod;

    @Override
    public void processPayment() {
        System.out.println("Processing card payment: " + cardNumber);
    }

    @Override
    public BigDecimal getAmount() {
        return getAmountValue();
    }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }
}