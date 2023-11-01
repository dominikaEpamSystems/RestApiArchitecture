package com.epam.serviceapi.repository;

import com.epam.dto.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Subscription, Long> {

}