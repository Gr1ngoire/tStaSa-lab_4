package com.example.server.entities;

public class PaymentEntity {
    private Long id;
    private double amount;
    private String currency;
    private String senderName;
    private String receiverName;
    private Long appointmentId;

    public PaymentEntity(Long id, double amount, String currency, String senderName, String receiverName, Long appointmentId) {
        this.id = id;
        this.amount = amount;
        this.currency = currency;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.appointmentId = appointmentId;
    }

    public PaymentEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
}
