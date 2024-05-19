package com.example.server.dtos;

public class PaymentDTO {
    private double amount;
    private String currency;
    private String senderName;
    private String receiverName;
    private Long appointmentId;

    public PaymentDTO(double amount, String currency, String senderName, String receiverName, Long appointmentId) {
        this.amount = amount;
        this.currency = currency;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.appointmentId = appointmentId;
    }

    public PaymentDTO() {
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }
}
