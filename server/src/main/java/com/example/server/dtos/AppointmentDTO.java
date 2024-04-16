package com.example.server.dtos;

public class AppointmentDTO {
    private String date;
    private String time;

    public AppointmentDTO(String date, String time) {
        this.date = date;
        this.time = time;
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
}
