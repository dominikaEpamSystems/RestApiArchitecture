package com.epam.dto;

public class SubscriptionRequestDto {
    private Long id;
    private Long userId;

    public SubscriptionRequestDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
