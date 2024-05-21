package com.example.server.services;

import com.example.server.dtos.DoctorDTO;
import com.example.server.entities.DoctorEntity;
import com.example.server.repositories.DoctorRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<DoctorDTO> getAllDoctors(){
        return doctorRepository.getAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DoctorEntity create(DoctorDTO doctorDTO){
        DoctorEntity doctorEntity = new DoctorEntity(doctorRepository.getSize(),
                doctorDTO.getName(), doctorDTO.getEmail(), doctorDTO.getPassword());
        doctorRepository.create(doctorEntity);
        return doctorEntity;
    }

    public DoctorDTO getDoctorById(Long id){
        DoctorEntity entity = doctorRepository.getById(id);
        return entity != null ? convertToDTO(entity) : null;
    }

    public void delete(Long id){
        doctorRepository.delete(id);
    }

    private DoctorDTO convertToDTO(DoctorEntity doctorEntity) {
        return new DoctorDTO(
                doctorEntity.getName(),
                doctorEntity.getEmail(),
                doctorEntity.getPassword());
    }
}
