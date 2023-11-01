package com.epam.servicerest.links;

import com.epam.dto.UserResponseDto;
import com.epam.servicerest.controller.UserController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserLinks implements SimpleRepresentationModelAssembler<UserResponseDto> {

    @Override
    public void addLinks(EntityModel<UserResponseDto> resource) {
        Long userId = Objects.requireNonNull(resource.getContent()).getId();
        resource.add(linkTo(methodOn(UserController.class).getUser(userId)).withSelfRel());
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<UserResponseDto>> resources) {
        resources.add(linkTo(methodOn(UserController.class).getAllUsers()).withSelfRel());
    }
}
