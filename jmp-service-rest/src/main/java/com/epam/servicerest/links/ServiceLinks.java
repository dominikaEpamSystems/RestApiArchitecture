package com.epam.servicerest.links;

import com.epam.dto.SubscriptionResponseDto;
import com.epam.servicerest.controller.ServiceController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.SimpleRepresentationModelAssembler;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ServiceLinks implements SimpleRepresentationModelAssembler<SubscriptionResponseDto> {
    @Override
    public void addLinks(EntityModel<SubscriptionResponseDto> resource) {
        Long userId = Objects.requireNonNull(resource.getContent()).getId();
        resource.add(linkTo(methodOn(ServiceController.class).getSubscription(userId)).withSelfRel());
    }

    @Override
    public void addLinks(CollectionModel<EntityModel<SubscriptionResponseDto>> resources) {
        resources.add(linkTo(methodOn(ServiceController.class).getAllSubscription()).withSelfRel());
    }
}
