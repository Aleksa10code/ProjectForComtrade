package rs.edu.code.ProjectForComtradeVersion3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.edu.code.ProjectForComtradeVersion3.dao.EventRepository;
import rs.edu.code.ProjectForComtradeVersion3.model.Event;
import rs.edu.code.ProjectForComtradeVersion3.model.EventStatus;
import rs.edu.code.ProjectForComtradeVersion3.model.People;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;

    public Event create(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAll() {
        return eventRepository.findAll();
    }

    public Event getById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Event sa id-em " + id + " ne postoji"));
    }

    public Event update(Event updateEvent) {
        Event dbEvent = getById(updateEvent.getId());
        dbEvent.setTitle(updateEvent.getTitle());
        dbEvent.setDescription(updateEvent.getDescription());
        dbEvent.setDate(updateEvent.getDate());
        dbEvent.setLocation(updateEvent.getLocation());
        dbEvent.setCapacity(updateEvent.getCapacity());
        dbEvent.setEventStatus(updateEvent.getEventStatus());
        return eventRepository.save(dbEvent);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }

}
