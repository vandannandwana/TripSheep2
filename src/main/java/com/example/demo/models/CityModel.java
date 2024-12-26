package com.example.demo.models;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document()
public class CityModel {

	@Id
	private String _id;
	private String city_id;
	private String name;
	private String state;
	private String country;
	private Double longitude;
	private Double latitude;
	private List<VisitingPlaceModel> visitingPlaces;
	
	public CityModel() {
		super();
	}
	
	public CityModel(String id, String name, String state, String country, Double longitude, Double latitude,
			List<VisitingPlaceModel> visitingPlaces) {
		super();
		this._id = id;
		this.name = name;
		this.state = state;
		this.country = country;
		this.longitude = longitude;
		this.latitude = latitude;
		this.visitingPlaces = visitingPlaces;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public List<VisitingPlaceModel> getVisitingPlaces() {
		return visitingPlaces;
	}
	public void setVisitingPlaces(List<VisitingPlaceModel> visitingPlaces) {
		this.visitingPlaces = visitingPlaces;
	}
	
	
	
	
}
