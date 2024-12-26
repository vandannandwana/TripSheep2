package com.example.demo.controllers;


import java.util.List;

import com.example.demo.models.*;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TripController {
	
	@Autowired
	CityRepository crepo;

	@Autowired
	HotelRepository hotelRepo;
	
	@Autowired
	VisitingPlaceRepository vrepo;
	
	@Autowired
	HillStationRepository hrepo;
	
	@Autowired
	TripPlanRepository trepo;
	
	@Autowired
	TripPackageRepository prepo;
	
	@GetMapping("/")
	public List<CityModel> getcities(){
		return crepo.findAll();
	}
	
	@PostMapping("/addCity")
	public ResponseEntity<String> addCity(@RequestBody CityModel city) {
		city.set_id(city.getCity_id());
	    crepo.save(city);
	    return ResponseEntity.ok("City Added Successfully");
	}

	@GetMapping("/getCities")
	public List<CityModel> getCities(){

		return crepo.findAll();

	}
	
	@PostMapping("/addhills")
	public void addHills(@RequestBody List<HillStationModel> hillStations) {
		for(HillStationModel hillStation : hillStations) {
			hillStation.set_id(hillStation.getHillId());
		}
		hrepo.saveAll(hillStations);
		
	}
	
	@GetMapping("/hills")
	public List<HillStationModel> addHills() {
		
		return hrepo.findAll();
		
	}

	@PostMapping("/addtrips")
	public void addTrips(@RequestBody List<TripPlanModel> trips) {
		for(TripPlanModel trip : trips) {
			trip.set_id(trip.getTrip_id());
		}
		trepo.saveAll(trips);
	}
	
	@GetMapping("/trips")
	public List<TripPlanModel> getTrips(){
		return trepo.findAll();
	}
	
	@PostMapping("/addPackages")
	public ResponseEntity<String> addPackages(@RequestBody List<TripPackageModel> tripPackage){
		try {
			for(TripPackageModel trip_package : tripPackage) {
				trip_package.set_id(trip_package.getTripPackageId());
			}
			prepo.saveAll(tripPackage);
			return ResponseEntity.ok("Package Added Successfully");
		}catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
		
	}

	@GetMapping("/hotel/{hotelId}")
	public HotelModel addHotel(@PathVariable("hotelId") String hotelId) {

		return hotelRepo.findBy_id(hotelId);

	}
	
	@GetMapping("/getPackages")
	public List<TripPackageModel> getPackages(){
		return prepo.findAll();
	}

	@GetMapping("/deleteallPackages")
	public void deleteAllPackages(){
		prepo.deleteAll();
	}

	@GetMapping("/deleteallPlans")
	public void deleteAllPlans(){
		trepo.deleteAll();
	}
	
	
}
