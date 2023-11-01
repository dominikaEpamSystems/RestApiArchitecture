package com.epam.servicerest.controller;

import com.epam.cloudservice.impl.ServiceServiceImpl;
import com.epam.dto.SubscriptionRequestDto;
import com.epam.dto.SubscriptionResponseDto;
import com.epam.servicerest.links.ServiceLinks;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subscriptions")
public class ServiceController {

    private final ServiceServiceImpl serviceService;
    private final ServiceLinks serviceLinks;

    public ServiceController(ServiceServiceImpl serviceService, ServiceLinks serviceLinks) {
        this.serviceService = serviceService;
        this.serviceLinks = serviceLinks;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<SubscriptionResponseDto>>> getAllSubscription() {
        return ResponseEntity.ok(serviceLinks.toCollectionModel(serviceService.getAllSubscription()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<SubscriptionResponseDto>> getSubscription(@PathVariable("id") Long subscriptionId) {
        SubscriptionResponseDto subscriptionResponseDto = serviceService.getSubscription(subscriptionId);
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = serviceLinks.toModel(subscriptionResponseDto);
        return ResponseEntity.ok(subscriptionResponseDtoEntityModel);
    }

    @PostMapping
    public ResponseEntity<EntityModel<SubscriptionResponseDto>> createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        SubscriptionResponseDto subscriptionResponseDto = serviceService.createSubscription(subscriptionRequestDto);
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = serviceLinks.toModel(subscriptionResponseDto);
        return ResponseEntity.ok(subscriptionResponseDtoEntityModel);
    }

    @PutMapping
    public ResponseEntity<EntityModel<SubscriptionResponseDto>> updateSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        SubscriptionResponseDto subscriptionResponseDto = serviceService.updateSubscription(subscriptionRequestDto);
        EntityModel<SubscriptionResponseDto> subscriptionResponseDtoEntityModel = serviceLinks.toModel(subscriptionResponseDto);
        return ResponseEntity.ok(subscriptionResponseDtoEntityModel);
    }

    @DeleteMapping("/{id}")
    public boolean deleteSubscription(@PathVariable("id") Long subscriptionId) {
        return serviceService.deleteSubscription(subscriptionId);
    }

}
