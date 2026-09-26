package com.example.events;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
class EventController {

    private final EventRepository repository;

    EventController(EventRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/events")
    List<Event> all() {
        return (List<Event>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/events/add")
    Event newEvent(@RequestBody Event newEvent) {
        return repository.save(newEvent);
    }

    // Single item
    @GetMapping("/events/{id}")
    Event one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    // Single item
    @GetMapping("/events/filter")
    List<Event> getEventByCity(@RequestParam(required = false) City city,
                               @RequestParam(required = false) String mainType) {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .filter(e ->
                        (StringUtils.isBlank(city == null ? null : city.toString()) || e.getCity().equals(city)) &&
                                (StringUtils.isBlank(mainType) || e.getMainType().equals(mainType))
                ).toList();
    }

    @PutMapping("/events/{id}")
    Event replaceEvent(@RequestBody Event newEvent, @PathVariable Long id) {

        return repository.findById(id)
                .map(event -> {
                    event.setEventName(newEvent.getEventName());
                    event.setDescription(newEvent.getDescription());
                    return repository.save(event);
                })
                .orElseGet(() -> {
                    return repository.save(newEvent);
                });
    }

    @DeleteMapping("/events/{id}")
    void deleteEvent(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
