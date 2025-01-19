package com.smartcity.smartcity.controller;

import com.smartcity.smartcity.model.Category;
import com.smartcity.smartcity.model.Facility;
import com.smartcity.smartcity.service.CategoryService;
import com.smartcity.smartcity.service.FacilityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final FacilityService facilityService;

    public CategoryController(CategoryService categoryService, FacilityService facilityService) {
        this.categoryService = categoryService;
        this.facilityService = facilityService;
    }

    @GetMapping
    public String getAllCategories(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "categories/categories";
    }

    @PostMapping
    public String saveCategory(@ModelAttribute Category category) {
        categoryService.createCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/{id}")
    public String getCategoryById(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "categories/categories";
    }

    @GetMapping("/{id}/edit")
    public String editCategoryForm(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "categories/category-update";
    }

    @PostMapping("/{id}/edit")
    public String updateCategory(@PathVariable Long id, @ModelAttribute Category category) {
        categoryService.updateCategory(id, category);
        return "redirect:/categories";
    }

    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }

    // Get facility by category
    @GetMapping("/{categoryId}/{categoryName}/facilities")
    public String getFacilitiesByCategory(@PathVariable Long categoryId, @PathVariable String categoryName, Model model) {
        List<Facility> facilities = facilityService.getFacilitiesByCategory(categoryId);
        Category category = categoryService.getCategoryById(categoryId);
        model.addAttribute("facilities", facilities);
        model.addAttribute("category", category);
        return "facilities/category-facilities";
    }
}
