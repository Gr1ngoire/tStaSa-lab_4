package com.example.server.repositories;

import com.example.server.entities.AppointmentEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppointmentRepository {
    private final List<AppointmentEntity> appointmentEntities = new ArrayList<>();

    public void create(AppointmentEntity entity){
        appointmentEntities.add(entity);
    }

    public void delete(Long id){
        appointmentEntities.removeIf(entity -> entity.getId().equals(id));
    }

    public long getSize(){
        return appointmentEntities.size() + 1;
    }
}
