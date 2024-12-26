package com.example.demo.models;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class HillStationModel {

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Id
    private String _id;

    private String hillId;

    public String getHillId() {
        return hillId;
    }

    public void setHillId(String hillId) {
        this.hillId = hillId;
    }

    private String name;
    
    private Double longitude;
    
    private Double latitude;
    
    private String city;
    
    private String state;
    
    private Double rating;

    private List<String> images;

    // Default constructor
    public HillStationModel() {
    }

    // Parameterized constructor
    public HillStationModel(String _id, String name, Double longitude, Double latitude, String city, String state, Double rating, List<String> images) {
        this._id = _id;
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.state = state;
        this.rating = rating;
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
