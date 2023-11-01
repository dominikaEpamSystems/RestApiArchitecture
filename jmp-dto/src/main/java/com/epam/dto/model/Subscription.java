package com.epam.dto.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @Column(name = "start_date")
    private LocalDate startDate;

    public Subscription() {
    }

    public Subscription(Long id, User user, LocalDate startDate) {
        this.id = id;
        this.user = user;
        this.startDate = startDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
