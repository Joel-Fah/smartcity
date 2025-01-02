package com.smartcity.smartcity.repository;

import com.smartcity.smartcity.model.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacilityRepository extends JpaRepository<Facility, Long> {
    // Additional query methods (if any) can be added here
}
