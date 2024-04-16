package com.example.server.repositories;

import com.example.server.entities.DoctorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DoctorRepository {
    private final List<DoctorEntity> doctorEntities = new ArrayList<>();

    public void create(DoctorEntity entity){
        doctorEntities.add(entity);
    }

    public void delete(Long id){
        doctorEntities.removeIf(entity -> entity.getId().equals(id));
    }

    public long getSize(){
        return doctorEntities.size() + 1;
    }
}
