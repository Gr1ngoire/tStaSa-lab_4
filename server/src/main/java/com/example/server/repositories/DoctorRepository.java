package com.example.server.repositories;

import com.example.server.entities.DoctorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorRepository {
    private final List<DoctorEntity> doctorEntities = new ArrayList<>(List.of(
            new DoctorEntity(1L, "Dr. John Smith", "john.smith@example.com", "password123"),
            new DoctorEntity(2L, "Dr. Jane Doe", "jane.doe@example.com", "securePass!"),
            new DoctorEntity(3L, "Dr. Emily Davis", "emily.davis@example.com", "myPassword#1"),
            new DoctorEntity(4L, "Dr. Michael Brown", "michael.brown@example.com", "passw0rd")
    ));

    public void create(DoctorEntity entity){
        doctorEntities.add(entity);
    }

    public DoctorEntity getById(Long id){
        return doctorEntities.stream()
                .filter(doctorEntity -> doctorEntity.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<DoctorEntity> getAll(){
        return doctorEntities;
    }

    public void delete(Long id){
        doctorEntities.removeIf(entity -> entity.getId().equals(id));
    }

    public long getSize(){
        return doctorEntities.size() + 1;
    }
}
