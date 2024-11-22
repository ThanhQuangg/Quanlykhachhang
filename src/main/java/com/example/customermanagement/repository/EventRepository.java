package com.example.customermanagement.repository;

import com.example.customermanagement.pojo.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
    List<Event> findByCustomerId(Integer customerId);
}

