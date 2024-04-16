package com.example.server.controllers;

import com.example.server.dtos.AppointmentDTO;
import com.example.server.services.AppointmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("")
    public void create(@RequestBody AppointmentDTO appointmentDTO){


    }

    @DeleteMapping("/{id}")
    public void create(@PathVariable Long id){


    }
}