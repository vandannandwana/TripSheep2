package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.data.mongodb.core.mapping.Document;

public class VisitingPlaceModel {
    private String _id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getVisiting_place_id() {
		return visiting_place_id;
	}

	public void setVisiting_place_id(String visiting_place_id) {
		this.visiting_place_id = visiting_place_id;
	}

	private String visiting_place_id;
    private String name;
    private String description;
    private Double longitude;
    private Double latitude;
    private Double entryFee;
    private String openingHours;
    private Double rating;
    private String imageUrl;
    

	public VisitingPlaceModel() {
		super();
	}

	public VisitingPlaceModel(String _id, String name, String description, Double longitude, Double latitude,
							  Double entryFee, String openingHours, Double rating, String imageUrl, CityModel city) {
		super();
		this._id = _id;
		this.name = name;
		this.description = description;
		this.longitude = longitude;
		this.latitude = latitude;
		this.entryFee = entryFee;
		this.openingHours = openingHours;
		this.rating = rating;
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Double getEntryFee() {
		return entryFee;
	}

	public void setEntryFee(Double entryFee) {
		this.entryFee = entryFee;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
    
    
	
}
