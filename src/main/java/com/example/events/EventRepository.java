package com.example.events;

import org.springframework.data.repository.CrudRepository;

interface EventRepository extends CrudRepository<Event, Long> {

}