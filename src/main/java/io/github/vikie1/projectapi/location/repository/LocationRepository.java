package io.github.vikie1.projectapi.location.repository;

import io.github.vikie1.projectapi.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByCityAndCountry(String city, String country);
}
