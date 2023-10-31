package com.epam.serviceapi.service;

import com.epam.dto.UserRequestDto;
import com.epam.dto.UserResponseDto;

import java.util.List;

public interface UserService {
    public List<UserResponseDto> getAllUsers();

    public UserResponseDto getUser(Long userid);

    public UserResponseDto createUser(UserRequestDto userRequestDto);

    public UserResponseDto updateUser(UserRequestDto userRequestDto);

    public boolean deleteUser(Long userid);
}
