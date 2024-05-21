package com.example.server.dtos;

public class AppointmentDTO {
    private Long id;
    private String date;
    private String time;
    private Long doctor_id;

    public AppointmentDTO(Long id, String date, String time, Long doctor_id) {
        this.date = date;
        this.time = time;
        this.doctor_id = doctor_id;
        this.id = id;
    }

    public AppointmentDTO() {
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

    public Long getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Long doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
