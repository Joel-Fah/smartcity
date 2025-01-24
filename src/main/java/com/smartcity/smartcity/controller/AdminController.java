package com.smartcity.smartcity.controller;

import org.springframework.stereotype.Controller;
import com.smartcity.smartcity.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.smartcity.smartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class AdminController {

    @Autowired
    private UserService userService; // Declare and inject userService

    @GetMapping("/admin/home")
    public String adminHome() {
        return "admin-home";
    }
    @GetMapping("/admin/manage-users")
    public String manageUsers(Model model) {
        // Logic to retrieve user data (if any)
        model.addAttribute("users", userService.getAllUsers());
        return "admin/manage-users"; // View name (admin/manage-users.html)
    }

    @GetMapping("/admin/view-reports")
    public String viewReports(Model model) {
        // Logic to retrieve reports
        model.addAttribute("reports", reportService.getAllReports());
        return "admin/view-reports"; // View name (admin/view-reports.html)
    }

    @GetMapping("/admin/settings")
    public String settings(Model model) {
        // Logic to retrieve settings data (if any)
        return "admin/settings"; // View name (admin/settings.html)
    }

    @GetMapping("/admin/help")
    public String help(Model model) {
        // You could provide help information or FAQs here.
        return "admin/help"; // View name (admin/help.html)
    }
    private final ReportService reportService;

    // Constructor injection
    @Autowired
    public AdminController(ReportService reportService) {
        this.reportService = reportService;
    }
}
