package com.smartcity.smartcity.controller;
import com.smartcity.smartcity.service.ReportService;
import com.smartcity.smartcity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.smartcity.smartcity.model.User; // Import the User class



@Controller
public class AdminController {

    @Autowired
    private UserService userService;

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
    @Autowired
    public AdminController(ReportService reportService) {
        this.reportService = reportService;  // Assign the injected ReportService to the field
    }
}
