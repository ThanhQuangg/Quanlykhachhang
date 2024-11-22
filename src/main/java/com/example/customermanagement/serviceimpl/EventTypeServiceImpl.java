package com.example.customermanagement.serviceimpl;

import com.example.customermanagement.pojo.EventType;
import com.example.customermanagement.repository.EventTypeRepository;
import com.example.customermanagement.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventTypeServiceImpl implements EventTypeService {

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Override
    public List<EventType> getAllEventTypes() {
        return eventTypeRepository.findAll();
    }

    @Override
    public Optional<EventType> getEventTypeById(Integer eventTypeId) {
        return eventTypeRepository.findById(eventTypeId);
    }

    @Override
    public EventType createEventType(EventType eventType) {
        return eventTypeRepository.save(eventType);
    }

    @Override
    public EventType updateEventType(Integer eventTypeId, EventType eventType) {
        Optional<EventType> existingEventType = eventTypeRepository.findById(eventTypeId);
        if (existingEventType.isPresent()) {
            EventType updatedEventType = existingEventType.get();
            updatedEventType.setEventTypeName(eventType.getEventTypeName());
            return eventTypeRepository.save(updatedEventType);
        } else {
            throw new RuntimeException("Event Type not found");
        }
    }

    @Override
    public void deleteEventType(Integer eventTypeId) {
        eventTypeRepository.deleteById(eventTypeId);
    }
}

