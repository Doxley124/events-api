package com.example.events;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
class Event {

    private @Id
    @GeneratedValue Long id;
    private String eventName;
    private String description;
    private LocalDateTime date;
    private String location;
    private double price;
    private String mainType;

    public Event(String eventName, String description, LocalDateTime date,
                 String location, double price, String mainType) {
        this.eventName = eventName;
        this.description = description;
        this.date = date;
        this.location = location;
        this.price = price;
        this.mainType = mainType;
    }

    public Event() {
    }

    public Long getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public String getEventName() {
        return this.eventName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String pinyin) {
        this.description = pinyin;
    }

    public void setEventName(String hanzi) {
        this.eventName = hanzi;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
}