package com.example.demo.models;

import java.util.List;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TripPackageModel {

	@Id
	String _id;
	String tripPackageId;

	public String getTripPackageId() {
		return tripPackageId;
	}

	public void setTripPackageId(String tripPackageId) {
		this.tripPackageId = tripPackageId;
	}

	String packageName;
	List<String> imageUrls;
	String about;
	List<HotelModel> hotels;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public List<String> getImageUrls() {
		return imageUrls;
	}
	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public List<HotelModel> getHotels() {
		return hotels;
	}
	public void setHotels(List<HotelModel> hotels) {
		this.hotels = hotels;
	}
	
	
	
}
