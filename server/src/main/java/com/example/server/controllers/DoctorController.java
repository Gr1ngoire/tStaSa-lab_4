package com.example.server.controllers;

import com.example.server.dtos.DoctorDTO;
import com.example.server.entities.DoctorEntity;
import com.example.server.services.DoctorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("")
    public DoctorEntity create(@RequestBody DoctorDTO doctorDTO){
        return doctorService.create(doctorDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        doctorService.delete(id);
    }
}
