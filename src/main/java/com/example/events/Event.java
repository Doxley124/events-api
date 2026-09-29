package com.example.events;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
class Event {

    private @Id
    @GeneratedValue Long id;
    private String eventName;
    private String description;
    private LocalDateTime date;
    private City city;
    private String venue;
    private double price;
    private String mainType;
    private String imageURL;

    public Event(String eventName, String description, LocalDateTime date, City city, String venue, double price,
                 String mainType, String imageURL) {
        this.eventName = eventName;
        this.description = description;
        this.date = date;
        this.city = city;
        this.venue = venue;
        this.price = price;
        this.mainType = mainType;
        this.imageURL = imageURL;
    }

    public Event() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(String mainType) {
        this.mainType = mainType;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}