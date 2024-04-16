package com.example.server.controllers;

import com.example.server.dtos.AppointmentDTO;
import com.example.server.entities.AppointmentEntity;
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
    public AppointmentEntity create(@RequestBody AppointmentDTO appointmentDTO){
        return appointmentService.create(appointmentDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        appointmentService.delete(id);
    }
}
