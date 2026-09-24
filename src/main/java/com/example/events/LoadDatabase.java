package com.example.events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EventRepository eventRepository) {

        return args -> {
            log.info("Preloading " + eventRepository.save(
                    new Event(
                            "NOISE",
                            "Experimental music jam night.",
                            LocalDateTime.of(LocalDate.of(2026, 11, 20), LocalTime.NOON),
                            "The Shed - London",
                            11.99,
                            "music"
                    )
                )
            );
            log.info("Preloading " + eventRepository.save(
                            new Event(
                                    "Life Drawing",
                                    "1 hour life drawing class with 2 models.",
                                    LocalDateTime.of(LocalDate.of(2026, 12, 2), LocalTime.MIDNIGHT),
                                    "Willow Hall",
                                    8,
                                    "art"
                            )
                    )
            );
        };
    }
}