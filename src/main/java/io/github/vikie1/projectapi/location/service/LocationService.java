package io.github.vikie1.projectapi.location.service;

import io.github.vikie1.projectapi.location.entity.Location;
import io.github.vikie1.projectapi.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    //CREATE
    public void add(Location location) { locationRepository.save(location); }

    //READ
    public Location get(Location location){ return get(location.getCity(), location.getCountry()); }
    public Location get(String city, String country) { return locationRepository.findByCityAndCountry(city, country); }
}
