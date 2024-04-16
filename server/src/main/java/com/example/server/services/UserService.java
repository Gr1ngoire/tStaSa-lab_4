package com.example.server.services;

import com.example.server.dtos.AppointmentDTO;
import com.example.server.dtos.RegisterDTO;
import com.example.server.entities.AppointmentEntity;
import com.example.server.entities.UserEntity;
import com.example.server.repositories.AppointmentRepository;
import com.example.server.repositories.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity create(RegisterDTO registerDTO){
        UserEntity userEntity = new UserEntity(userRepository.getSize(),
                registerDTO.getEmail(), registerDTO.getPassword(), registerDTO.getName());
        userRepository.create(userEntity);
        return userEntity;
    }

    public UserEntity findByEmail(String email){
        return userRepository.findByEmail(email);
    }
}
