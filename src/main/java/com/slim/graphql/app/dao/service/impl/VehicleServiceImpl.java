package com.slim.graphql.app.dao.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.slim.graphql.app.dao.entity.Vehicle;
import com.slim.graphql.app.dao.repository.VehicleRepository;
import com.slim.graphql.app.dao.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService	 {

	private final VehicleRepository vehicleRepository;

	@Autowired
	public VehicleServiceImpl(final VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	@Override
	@Transactional(readOnly = true)
    public Optional<Vehicle> getVehicle(final int id) {
        return this.vehicleRepository.findById(id);
    }

	@Override
	public List<Vehicle> getAllVehicles(Integer count) {
        return this.vehicleRepository.findAll().stream().limit(count).collect(Collectors.toList());

	}

	@Override
	public Vehicle createVehicle(String type, String modelCode, String brandName, String launchDate) {
		final Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.vehicleRepository.save(vehicle);
	}

}
