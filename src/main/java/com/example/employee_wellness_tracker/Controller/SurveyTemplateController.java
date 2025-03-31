package com.example.employee_wellness_tracker.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_wellness_tracker.model.SurveyTemplate;
import com.example.employee_wellness_tracker.service.SurveyTemplateService;

/**
 * Controller for managing survey templates.
 * Provides endpoints for creating, updating, deleting, and retrieving surveys.
 */
@RestController
@RequestMapping("/api/surveys")
@CrossOrigin
public class SurveyTemplateController {

    @Autowired
    private SurveyTemplateService surveyTemplateService;

    /**
    * Creates a new survey template.
    *
    * @param surveyTemplate The survey template to be created.
    * @return ResponseEntity containing the created SurveyTemplate object.
    */
    @PostMapping("/create")
    public ResponseEntity<SurveyTemplate> createSurvey(@RequestBody SurveyTemplate surveyTemplate) {
        return ResponseEntity.ok(surveyTemplateService.createSurvey(surveyTemplate));
    }

    /**
    * Updates an existing survey template.
    *
    * @param id             The ID of the survey template to update.
    * @param surveyTemplate The updated survey template object.
    * @return ResponseEntity containing the updated SurveyTemplate object.
    */
    @PutMapping("/update/{id}")
    public ResponseEntity<SurveyTemplate> updateSurvey(@PathVariable Long id, @RequestBody SurveyTemplate surveyTemplate) {
        return ResponseEntity.ok(surveyTemplateService.updateSurvey(id, surveyTemplate));
    }

    /**
    * Deletes a survey template by its ID.
    *
    * @param id The ID of the survey template to be deleted.
    * @return ResponseEntity with a success message.
    */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSurvey(@PathVariable Long id) {
        surveyTemplateService.deleteSurvey(id);
        return ResponseEntity.ok("Survey deleted successfully");
    }

    /**
    * Retrieves all survey templates.
    *
    * @return ResponseEntity containing a list of all SurveyTemplate objects.
    */
    @GetMapping("/all")
    public ResponseEntity<List<SurveyTemplate>> getAllSurveys() {
        return ResponseEntity.ok(surveyTemplateService.getAllSurveys());
    }
}

