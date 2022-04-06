package com.hackerrank.gevents.service;

import com.hackerrank.gevents.model.Event;

import java.util.List;

public interface EventService {

    Event saveEvent(Event event);

    Event getEventById(Integer eventId);

    List<Event> getAllEvents();

    List<Event> getAllByRepoId(Integer repoId);
}
