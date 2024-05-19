package com.example.server.services;

import com.example.server.dtos.AppointmentDTO;
import com.example.server.entities.AppointmentEntity;
import com.example.server.repositories.AppointmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public List<AppointmentDTO> getAllAppointments() {
        return appointmentRepository.getAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AppointmentDTO getAppointmentById(Long id) {
        AppointmentEntity entity = appointmentRepository.getById(id);
        return entity != null ? convertToDTO(entity) : null;
    }

    public AppointmentEntity create(AppointmentDTO appointmentDTO){
        AppointmentEntity appointmentEntity = new AppointmentEntity(appointmentRepository.getSize(),
                appointmentDTO.getDate(), appointmentDTO.getTime(), 1L, 1L);
        appointmentRepository.create(appointmentEntity);
        return appointmentEntity;
    }



    public void delete(Long id){
        appointmentRepository.delete(id);
    }

    private AppointmentDTO convertToDTO(AppointmentEntity appointmentEntity) {
        return new AppointmentDTO(
                appointmentEntity.getDate(),
                appointmentEntity.getTime()
        );
    }
}
