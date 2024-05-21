package com.example.server.repositories;

import com.example.server.entities.AppointmentEntity;
import com.example.server.entities.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<UserEntity> appointmentEntities = List.of(
            new UserEntity(1L, "test@test.com", "John", "password"),
            new UserEntity(2L, "test2@test.com", "Jane", "password"),
            new UserEntity(3L, "test3@test.com", "Jack", "password"),
            new UserEntity(4L, "test4@test.com", "Jill", "password"));

    public void create(UserEntity entity) {
        appointmentEntities.add(entity);
    }

    public UserEntity findByEmail(String email) {
        return appointmentEntities.stream()
                .filter(userEntity -> userEntity.getEmail().equals(email)).findFirst().get();
    }

    public long getSize() {
        return appointmentEntities.size() + 1;
    }
}
