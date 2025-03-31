package com.example.employee_wellness_tracker.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employee_wellness_tracker.model.SurveyTemplate;
import com.example.employee_wellness_tracker.model.User;
import com.example.employee_wellness_tracker.service.SurveyTemplateService;
import com.example.employee_wellness_tracker.service.UserService;

/**
 * Controller for handling view-related mappings.
 * This controller maps endpoints to corresponding template pages.
 */
@Controller
public class ViewController {

    @Autowired
    private UserService userService;

    @Autowired
    private SurveyTemplateService surveyTemplateService;

    /**
     * Displays the login page.
     *
     * @return The login HTML page.
     */
    @GetMapping("/login")
    public String showLoginPage() {
        System.out.println("Inside login controller");
        return "login";  // Renders login.html from the templates folder
    }

    /**
     * Displays the admin dashboard.
     *
     * @return The admin dashboard HTML page.
     */
    @GetMapping("/admin_dashboard")
    public String adminDashboard() {
        return "admin_dashboard";  // Renders admin_dashboard.html
    }

    /**
     * Displays the employee dashboard.
     *
     * @return The employee dashboard HTML page.
     */
    @GetMapping("/employee_dashboard")
    public String employeeDashboard() {
        return "employee_dashboard";  // Renders employee_dashboard.html
    }

    /**
     * Displays the registration page.
     *
     * @return The registration HTML page.
     */
    @GetMapping("/register")
    public String showRegisterPage() {
        System.out.println("Inside register controller");
        return "register";  // Renders register.html
    }

    /**
     * Displays the update profile page.
     *
     * @return The update profile HTML page.
     */
    @GetMapping("/update_profile")
    public String profileUpdatePage() {
        return "update_profile";  // Renders update_profile.html
    }

    /**
     * Displays the manage employees page for the admin.
     *
     * @return The manage employees HTML page.
     */
    @GetMapping("/manage_employee")
    public String showManageEmployeesPage() {
        return "manage_employee";  // Renders manage_employee.html
    }

    /**
     * Displays the add employee page.
     *
     * @return The add employee HTML page.
     */
    @GetMapping("/add_employee")
    public String showAddEmployeePage() {
        return "add_employee";  // Renders add_employee.html
    }

    /**
     * Displays the edit employee page.
     *
     * @return The edit employee HTML page.
     */
    @GetMapping("/edit_employee")
    public String editEmployeePage() {
        return "edit_employee";  // Renders edit_employee.html
    }

    /**
     * Displays the edit employee page with employee details populated.
     *
     * @param id    The employee ID.
     * @param model The model to pass employee details to the view.
     * @return The edit employee HTML page.
     */
    @GetMapping("/edit_employee/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<User> employee = userService.getEmployeeById(id);
        if (employee.isPresent()) {
            model.addAttribute("employee", employee.get());
            return "edit_employee";  // Renders edit_employee.html
        } else {
            return "redirect:/manage_employee";  // Redirects if employee not found
        }
    }

    /**
     * Displays the survey template page.
     *
     * @return The survey template HTML page.
     */
    @GetMapping("/survey_template")
    public String surveyPage() {
        return "survey_template";  // Renders survey_template.html
    }

    /**
     * Displays the update survey template page.
     *
     * @return The update survey template HTML page.
     */
    @GetMapping("/update_survey_template")
    public String updateSurveyPage() {
        return "update_survey_template";  // Renders update_survey_template.html
    }

    /**
     * Retrieves a survey template by ID.
     *
     * @param id The survey template ID.
     * @return The survey template data as a ResponseEntity.
     */
    @GetMapping("/update_survey_template/{id}")
    public ResponseEntity<SurveyTemplate> getSurveyById(@PathVariable Long id) {
        SurveyTemplate survey = surveyTemplateService.getSurveyById(id);
        return ResponseEntity.ok(survey);
    }

    /**
     * Displays the survey submission page.
     *
     * @return The survey submission HTML page.
     */
    @GetMapping("/survey_submission")
    public String surveySubmission() {
        return "survey_submission";  // Renders survey_submission.html
    }

    /**
     * Displays the report page.
     *
     * @return The report genertion HTML page.
     */
    @GetMapping("/report")
    public String reportGeneration() {
        return "report";  // Renders report.html
    }
}
