package com.epam.cloudservice.impl;


import com.epam.serviceapi.repository.UserRepository;
import com.epam.dto.model.User;
import com.epam.dto.UserRequestDto;
import com.epam.dto.UserResponseDto;
import com.epam.serviceapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
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
        return userRepository.findAll()
                .stream()
                .map(this::mapUserResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponseDto getUser(Long userid) {
        return mapUserResponseDto(findUserById(userid));
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        return mapUserResponseDto(userRepository.save(
                Objects.requireNonNull(mapUser(userRequestDto))));
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        User user = findUserById(userRequestDto.getId());
        if (user != null) {
            user = mapUser(userRequestDto);
        }

        assert user != null;
        return mapUserResponseDto(userRepository.save(user));
    }

    @Override
    public boolean deleteUser(Long userid) {
        User user = findUserById(userid);
        if (user != null) {
            userRepository.delete(user);
            return true;
        } else {
            return false;
        }
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User %d not found.", id)));
    }

    public User mapUser(UserRequestDto userRequestDto) {
        Long id = userRequestDto.getId();
        String name = userRequestDto.getName();
        String surname = userRequestDto.getSurname();
        String birthday = userRequestDto.getBirthday();
        return new User(id, name, surname, LocalDate.parse(birthday));
    }

    public UserResponseDto mapUserResponseDto(User user) {
        Long id = user.getId();
        String name = user.getName();
        String surname = user.getSurname();
        String birthday = String.valueOf(user.getBirthday());
        return new UserResponseDto(id, name, surname, birthday);
    }
}
