package com.bilgeadam.service;

import com.bilgeadam.dto.request.RegisterRequestDto;
import com.bilgeadam.repository.IUserRepository;
import com.bilgeadam.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;


    public User createUser(User user) {

        return userRepository.save(user);
    }

    public User register(RegisterRequestDto dto) {
        User user=User.builder().phone(dto.getPhone()).name(dto.getName()).surName(dto.getSurName())
                .email(dto.getEmail()).password(dto.getPassword())
                .build();
      return   userRepository.save(user);
    }
}
