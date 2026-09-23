package com.example.events;

class EventNotFoundException extends RuntimeException {

    EventNotFoundException(Long id) {
        super("Could not find character " + id);
    }
}
