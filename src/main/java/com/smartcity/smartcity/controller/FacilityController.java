package com.smartcity.smartcity.controller;

import com.smartcity.smartcity.model.Facility;
import com.smartcity.smartcity.service.CategoryService;
import com.smartcity.smartcity.service.FacilityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;
    private final CategoryService categoryService;

    public FacilityController(FacilityService facilityService, CategoryService categoryService) {
        this.facilityService = facilityService;
        this.categoryService = categoryService;
    }

    // Utility methods
    public List<String> getTags(String tags) {
        return List.of(tags.split(","));
    }

    @GetMapping
    public String getAllFacilities(Model model) {
        model.addAttribute("facilities", facilityService.getAllFacilities());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "facilities/facilities";
    }

    @GetMapping("/{id}")
    public String getFacilityById(@PathVariable Long id, Model model) {
        Facility facility = facilityService.getFacilityById(id);
        model.addAttribute("facility", facility);
        return "facilities/facility-details";
    }

    @GetMapping("/new")
    public String createFacilityForm(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "facilities/facility-add";
    }

    @PostMapping("/new")
    public String saveFacility(@ModelAttribute Facility facility) {
        facilityService.createFacility(facility);
        return "redirect:/facilities";
    }

    @GetMapping("/{id}/edit")
    public String editFacilityForm(@PathVariable Long id, Model model) {
        Facility facility = facilityService.getFacilityById(id);
        model.addAttribute("facility", facility);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "facilities/facility-update";
    }

    @PostMapping("/{id}/edit")
    public String updateFacility(@PathVariable Long id, @ModelAttribute Facility facility) {
        facilityService.updateFacility(id, facility);
        return "redirect:/facilities/" + id;
    }

    @GetMapping("/{id}/delete")
    public String deleteFacility(@PathVariable Long id) {
        facilityService.deleteFacility(id);
        return "redirect:/facilities";
    }
}

