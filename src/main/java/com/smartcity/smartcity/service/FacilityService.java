package com.smartcity.smartcity.service;

import com.smartcity.smartcity.model.Facility;

import java.util.List;

public interface FacilityService {
    Facility createFacility(Facility facility);

    Facility updateFacility(Long id, Facility facility);

    Facility getFacilityById(Long id);

    List<Facility> getFacilitiesByCategory(Long categoryId);

    List<Facility> getAllFacilities();

    void deleteFacility(Long id);
}
