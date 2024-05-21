package com.example.server.repositories;

import com.example.server.entities.AppointmentEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AppointmentRepository {
    private final List<AppointmentEntity> appointmentEntities = new ArrayList<>(List.of(
            new AppointmentEntity(1L, "2024-06-01", "10:00", 1L, 1L),
            new AppointmentEntity(2L, "2024-06-02", "11:00", 2L, 2L),
            new AppointmentEntity(3L, "2024-06-03", "12:00", 3L, 3L),
            new AppointmentEntity(4L, "2024-06-04", "13:00", 4L, 4L)));

    public List<AppointmentEntity> getAppointmentEntities() {
        return appointmentEntities;
    }

    public AppointmentEntity getById(int id) {
        return appointmentEntities
                .stream()
                .filter(appointmentEntity -> appointmentEntity.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<AppointmentEntity> getAll() {
        return appointmentEntities;
    }

    public AppointmentEntity getById(Long id) {
        return appointmentEntities.stream()
                .filter(appointmentEntity -> appointmentEntity.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<AppointmentEntity> getByClientId(Long id) {
        return appointmentEntities.stream()
                .filter(appointmentEntity -> appointmentEntity.getClient_id() == id)
                .collect(Collectors.toList());
    }

    public void create(AppointmentEntity entity) {
        appointmentEntities.add(entity);
    }

    public void delete(Long id) {
        appointmentEntities.removeIf(entity -> entity.getId().equals(id));
    }

    public long getSize() {
        return appointmentEntities.size() + 1;
    }
}
