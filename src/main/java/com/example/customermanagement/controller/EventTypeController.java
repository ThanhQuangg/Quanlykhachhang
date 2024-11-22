package com.example.customermanagement.controller;

import com.example.customermanagement.pojo.Event;
import com.example.customermanagement.pojo.EventType;
import com.example.customermanagement.service.EventTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/event-types")
public class EventTypeController {

    @Autowired
    private EventTypeService eventTypeService;

    @GetMapping
    public List<EventType> getAllEventTypes() {
        return eventTypeService.getAllEventTypes();
    }

    @GetMapping("/{eventTypeId}")
    public ResponseEntity<EventType> getEventTypeById(@PathVariable Integer eventTypeId) {
        Optional<EventType> eventType = eventTypeService.getEventTypeById(eventTypeId);
        return eventType.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EventType> createEventType(@RequestBody EventType eventType) {
        EventType createdEventType = eventTypeService.createEventType(eventType);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEventType);
    }

    @PutMapping("/{eventTypeId}")
    public ResponseEntity<EventType> updateEventType(@PathVariable Integer eventTypeId, @RequestBody EventType eventTypeDetails) {
        EventType updateEventType = eventTypeService.updateEventType(eventTypeId, eventTypeDetails);
        return updateEventType != null ? ResponseEntity.ok(updateEventType) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{eventTypeId}")
    public ResponseEntity<Void> deleteEventType(@PathVariable Integer eventTypeId) {
        eventTypeService.deleteEventType(eventTypeId);
        return ResponseEntity.noContent().build();
    }
}

