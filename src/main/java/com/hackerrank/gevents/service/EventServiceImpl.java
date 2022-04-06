package com.hackerrank.gevents.service;

import com.hackerrank.gevents.exceptions.EventNotFoundException;
import com.hackerrank.gevents.model.Event;
import com.hackerrank.gevents.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{
    @Autowired
    private EventRepository eventRepository;

    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event getEventById(Integer eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new EventNotFoundException("Event Not Found for eventId : " + eventId));
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public List<Event> getAllByRepoId(Integer repoId) {
        return eventRepository.findByRepoId(repoId);
    }
}
