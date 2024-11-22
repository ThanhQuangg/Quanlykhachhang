package com.example.customermanagement.serviceimpl;

import com.example.customermanagement.pojo.Event;
import com.example.customermanagement.repository.EventRepository;
import com.example.customermanagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> getEventById(Integer eventId) {
        return eventRepository.findById(eventId);
    }

    @Override
    public List<Event> getEventsByCustomerId(Integer customerId) {
        return eventRepository.findByCustomerId(customerId);
    }

    @Override
    public Event createEvent(Event event) {
        LocalDateTime currentTime = LocalDateTime.now();
        event.setCreatedAt(currentTime);
        event.setUpdatedAt(currentTime);
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Integer eventId, Event event) {
        Optional<Event> existingEvent = eventRepository.findById(eventId);
        if (existingEvent.isPresent()) {
            Event updatedEvent = existingEvent.get();

            updatedEvent.setCustomerId(event.getCustomerId());
            updatedEvent.setProjectId(event.getProjectId());
            updatedEvent.setUserId(event.getUserId());
            updatedEvent.setEventTypeId(event.getEventTypeId());
            updatedEvent.setEventName(event.getEventName());
            updatedEvent.setDescription(event.getDescription());
            updatedEvent.setReminderDate(event.getReminderDate());
            updatedEvent.setReminderSent(event.getReminderSent());
            updatedEvent.setUpdatedAt(LocalDateTime.now());

            return eventRepository.save(updatedEvent);
        } else {
            throw new RuntimeException("Event not found");
        }
    }

    @Override
    public void deleteEvent(Integer eventId) {
        eventRepository.deleteById(eventId);
    }
}

