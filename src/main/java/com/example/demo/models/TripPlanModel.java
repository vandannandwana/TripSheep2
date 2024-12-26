package com.example.demo.models;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class TripPlanModel {

    @Id
    private String _id;
        private String trip_id;

    public String getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(String trip_id) {
        this.trip_id = trip_id;
    }

    private String name;
    private double priceAdult;
    private double priceChild;

    private int days;
    private List<String> placesToVisit;

    private String description;
    private double priceOffer;
    private List<String> tripImages;

    // Itinerary of the trip
    private String itinerary;

    // Getters and Setters

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceAdult() {
        return priceAdult;
    }

    public void setPriceAdult(double priceAdult) {
        this.priceAdult = priceAdult;
    }

    public double getPriceChild() {
        return priceChild;
    }

    public void setPriceChild(double priceChild) {
        this.priceChild = priceChild;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public List<String> getPlacesToVisit() {
        return placesToVisit;
    }

    public void setPlacesToVisit(List<String> placesToVisit) {
        this.placesToVisit = placesToVisit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceOffer() {
        return priceOffer;
    }

    public void setPriceOffer(double priceOffer) {
        this.priceOffer = priceOffer;
    }

    public List<String> getTripImages() {
        return tripImages;
    }

    public void setTripImages(List<String> tripImages) {
        this.tripImages = tripImages;
    }

    public String getItinerary() {
        return itinerary;
    }

    public void setItinerary(String itinerary) {
        this.itinerary = itinerary;
    }
}
