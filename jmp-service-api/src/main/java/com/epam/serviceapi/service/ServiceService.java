package com.epam.serviceapi.service;

import com.epam.dto.SubscriptionRequestDto;
import com.epam.dto.SubscriptionResponseDto;

import java.util.List;

public interface ServiceService {

    List<SubscriptionResponseDto> getAllSubscription();

    SubscriptionResponseDto getSubscription(Long subscriptionId);

    SubscriptionResponseDto createSubscription(SubscriptionRequestDto subscriptionRequestDto);

    SubscriptionResponseDto updateSubscription(SubscriptionRequestDto subscriptionRequestDto);

    boolean deleteSubscription(Long subscriptionId);

}
