package com.epam.cloudservice.impl;


import com.epam.cloudservice.repo.UserRepository;
import com.epam.dto.User;
import com.epam.dto.UserRequestDto;
import com.epam.dto.UserResponseDto;
import com.epam.serviceapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserResponseDto> getAllUsers() {

    }

    @Override
    public UserResponseDto getUser(Long userid) {

    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {

    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {

    }

    @Override
    public boolean deleteUser(Long userid) {

    }

    public User findUserById(Long id) {

    }
}
