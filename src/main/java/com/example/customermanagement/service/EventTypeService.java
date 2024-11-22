package com.example.customermanagement.service;

import com.example.customermanagement.pojo.EventType;

import java.util.List;
import java.util.Optional;

public interface EventTypeService {
    List<EventType> getAllEventTypes();
    Optional<EventType> getEventTypeById(Integer eventTypeId);
    EventType createEventType(EventType eventType);
    EventType updateEventType(Integer eventTypeId, EventType eventType);
    void deleteEventType(Integer eventTypeId);
}

