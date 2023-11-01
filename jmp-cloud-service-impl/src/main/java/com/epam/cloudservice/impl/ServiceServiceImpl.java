package com.epam.cloudservice.impl;

import com.epam.dto.UserRequestDto;
import com.epam.dto.UserResponseDto;
import com.epam.dto.model.User;
import com.epam.serviceapi.repository.ServiceRepository;
import com.epam.dto.model.Subscription;
import com.epam.dto.SubscriptionRequestDto;
import com.epam.dto.SubscriptionResponseDto;
import com.epam.serviceapi.service.ServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
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
        return serviceRepository.findAll().stream()
                .map(this::mapSubscriptionResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public SubscriptionResponseDto getSubscription(Long subscriptionId) {
        return mapSubscriptionResponseDto(findSubscriptionById(subscriptionId));
    }

    @Override
    public SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        return mapSubscriptionResponseDto(serviceRepository.save(mapSubscription(subscriptionRequestDto,
                userService.findUserById(subscriptionRequestDto.getUserId()))));
    }

    @Override
    public SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto) {
        Subscription subscription = findSubscriptionById(subscriptionRequestDto.getId());
        if (subscription != null) {
            subscription = mapSubscription(subscriptionRequestDto,
                    userService.findUserById(subscriptionRequestDto.getUserId()));
        }

        assert subscription != null;
        return mapSubscriptionResponseDto(serviceRepository.save(subscription));

    }

    @Override
    public boolean deleteSubscription(Long subscriptionId) {
        Subscription subscription = findSubscriptionById(subscriptionId);
        if (subscription != null) {
            serviceRepository.delete(subscription);
            return true;
        } else {
            return false;
        }
    }

    private Subscription findSubscriptionById(Long id) {
        return serviceRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Subscription %d not found.", id)));
    }

    public Subscription mapSubscription(SubscriptionRequestDto subscriptionRequestDto, User user) {
        Long id = subscriptionRequestDto.getId();
        LocalDate startDate = LocalDate.now();
        return new Subscription(id, user, startDate);
    }

    public SubscriptionResponseDto mapSubscriptionResponseDto(Subscription subscription) {
        Long id = subscription.getId();
        Long userId = subscription.getUser().getId();
        String startDate = String.valueOf(subscription.getStartDate());
        return new SubscriptionResponseDto(id, userId, startDate);
    }

}
