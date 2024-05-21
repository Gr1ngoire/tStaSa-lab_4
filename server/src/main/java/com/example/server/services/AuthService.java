package com.example.server.services;

import com.example.server.dtos.LoginDTO;
import com.example.server.dtos.RegisterDTO;
import com.example.server.entities.UserEntity;
import com.example.server.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity register(RegisterDTO registerDTO){
        UserEntity userEntity = new UserEntity(userRepository.getSize(),
                registerDTO.getEmail(), registerDTO.getPassword(), registerDTO.getName());
        userRepository.create(userEntity);
        return userEntity;
    }

    public UserEntity login(LoginDTO loginDTO){
        if(userRepository.findByEmail(loginDTO.getEmail())
                .getPassword().equals(loginDTO.getPassword())){
            return userRepository.findByEmail(loginDTO.getEmail());
        }
        return null;
    }

    public Long checkAuth(){
        return 0L;
    }

}
