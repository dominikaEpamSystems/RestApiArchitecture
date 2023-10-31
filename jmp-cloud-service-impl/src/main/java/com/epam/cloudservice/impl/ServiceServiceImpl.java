package com.epam.cloudservice.impl;

import com.epam.cloudservice.repo.ServiceRepository;
import com.epam.dto.Subscription;
import com.epam.dto.SubscriptionRequestDto;
import com.epam.dto.SubscriptionResponseDto;
import com.epam.serviceapi.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    private final UserServiceImpl userService;

    public ServiceServiceImpl(ServiceRepository serviceRepository, UserServiceImpl userService) {
        this.serviceRepository = serviceRepository;
        this.userService = userService;
    }


    @Override
    public List<SubscriptionResponseDto> getAllSubscription() {

    }

    @Override
    public SubscriptionResponseDto getSubscription(Long subscriptionId) {

    }

    @Override
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto) {

    }

    @Override
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto) {


    }

    @Override
    public boolean deleteSubscription(Long subscriptionId) {

    }

    private Subscription findSubscriptionById(Long id) {

    }
}
