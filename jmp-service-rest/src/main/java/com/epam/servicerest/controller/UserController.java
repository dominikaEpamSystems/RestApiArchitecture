package com.epam.servicerest.controller;

import com.epam.cloudservice.impl.UserServiceImpl;
import com.epam.dto.UserRequestDto;
import com.epam.dto.UserResponseDto;
import com.epam.servicerest.links.UserLinks;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    private final UserLinks userLinks;

    public UserController(UserServiceImpl userService, UserLinks userLinks) {
        this.userService = userService;
        this.userLinks = userLinks;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<UserResponseDto>>> getAllUsers() {
        return ResponseEntity.ok(userLinks.toCollectionModel(userService.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UserResponseDto>> getUser(@PathVariable("id") Long userId) {
        UserResponseDto userResponseDto = userService.getUser(userId);
        EntityModel<UserResponseDto> userResponseDtoEntityModel = userLinks.toModel(userResponseDto);
        return new ResponseEntity<>(userResponseDtoEntityModel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EntityModel<UserResponseDto>> createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        EntityModel<UserResponseDto> userResponseDtoEntityModel = userLinks.toModel(userResponseDto);
        return new ResponseEntity<>(userResponseDtoEntityModel, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EntityModel<UserResponseDto>> updateUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.updateUser(userRequestDto);
        EntityModel<UserResponseDto> userResponseDtoEntityModel = userLinks.toModel(userResponseDto);
        return new ResponseEntity<>(userResponseDtoEntityModel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable("id") Long userId) {
        return userService.deleteUser(userId);
    }

}
