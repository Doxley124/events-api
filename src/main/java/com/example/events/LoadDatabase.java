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
                            City.LONDON,
                            "The Shed",
                            11.99,
                            "music",
                            "noise-poster.png"
                    )
                )
            );
            log.info("Preloading " + eventRepository.save(
                    new Event(
                            "Life Drawing",
                            "1 hour life drawing class with 2 models.",
                            LocalDateTime.of(LocalDate.of(2026, 12, 2), LocalTime.MIDNIGHT),
                            City.BRISTOL,
                            "Willow Hall",
                            8,
                            "art",
                            "life-drawing-poster.jpeg"
                    )
                )
            );
            log.info("Preloading " + eventRepository.save(
                            new Event(
                                    "Gardening Project",
                                    "Join a team of gardeners in the local park.",
                                    LocalDateTime.of(LocalDate.of(2027, 1, 4), LocalTime.MIDNIGHT),
                                    City.BRISTOL,
                                    "Square Park",
                                    0,
                                    "community",
                                    "gardening-poster.jpeg"
                            )
                    )
            );
            log.info("Preloading " + eventRepository.save(
                            new Event(
                                    "Loud Mouth Presents...",
                                    "Rock n Roll music by Loud Mouth Records",
                                    LocalDateTime.of(LocalDate.of(2027, 3, 14), LocalTime.MIDNIGHT),
                                    City.LONDON,
                                    "The Basement",
                                    10,
                                    "music",
                                    "loud-mouth-poster.jpg"
                            )
                    )
            );
        };
    }
}