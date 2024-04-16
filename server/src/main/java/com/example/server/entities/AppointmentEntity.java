package com.example.server.entities;

public class AppointmentEntity {
    private Long id;
    private String date;
    private String time;
    private Long client_id;
    private Long doctor_id;

    public AppointmentEntity(Long id, String date, String time, Long client_id, Long doctor_id) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.client_id = client_id;
        this.doctor_id = doctor_id;
    }

    public AppointmentEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }
}
