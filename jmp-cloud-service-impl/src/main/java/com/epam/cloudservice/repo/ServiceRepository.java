package com.epam.cloudservice.repo;

import com.epam.dto.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Subscription, Long> {

}