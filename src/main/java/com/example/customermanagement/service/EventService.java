package com.example.customermanagement.service;

import com.example.customermanagement.pojo.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> getAllEvents();
    List<Event> getEventsByCustomerId(Integer customerId);
    Optional<Event> getEventById(Integer eventId);
    Event createEvent(Event event);
    Event updateEvent(Integer eventId, Event event);
    void deleteEvent(Integer eventId);
}

