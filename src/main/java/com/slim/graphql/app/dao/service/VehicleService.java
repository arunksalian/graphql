package com.slim.graphql.app.dao.service;

import java.util.List;
import java.util.Optional;

import com.slim.graphql.app.dao.entity.Vehicle;

public interface VehicleService {

	Optional<Vehicle> getVehicle(int id);
	List<Vehicle> getAllVehicles(Integer count);
	public Vehicle createVehicle(String type, final String modelCode, final String brandName, final String launchDate);
}
