package com.example.server.controllers;

import com.example.server.dtos.DoctorDTO;
import com.example.server.entities.DoctorEntity;
import com.example.server.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("")
    public List<DoctorDTO> getAllDoctors(){
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorDTO getDoctorById(@PathVariable Long id){
        return doctorService.getDoctorById(id);
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
