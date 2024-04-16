package com.example.server.services;

import com.example.server.dtos.AppointmentDTO;
import com.example.server.entities.AppointmentEntity;
import com.example.server.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void create(AppointmentDTO appointmentDTO){
        AppointmentEntity appointmentEntity = new AppointmentEntity(appointmentRepository.getSize(),
                appointmentDTO.getDate(), appointmentDTO.getTime(), 1L, 1L);
    }

    public void delete(Long id){
        appointmentRepository.delete(id);
    }
}
