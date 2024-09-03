package com.sxntixgxs.survey.surveys.infrastructure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sxntixgxs.survey.surveys.application.SurveyServices;
import com.sxntixgxs.survey.surveys.domain.models.Survey;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/surveys")
public class SurveyController {
    @Autowired
    private final SurveyServices services;

    public SurveyController(SurveyServices services) {
        this.services = services;
    }
    @PostMapping("/create")
    public ResponseEntity<Survey> createSurvey(@RequestBody Survey survey){
        Survey createdSurvey = services.create(survey);
        return ResponseEntity.ok(createdSurvey);
    }
    @GetMapping
    public ResponseEntity<List<Survey>> getAllSurveys(){
        List<Survey> surveys = services.getAllSurveys();
        return ResponseEntity.ok(surveys);  
    }
    @PutMapping("/{id}")
    public ResponseEntity<Survey> updateSurvey(@PathVariable Integer id, @RequestBody Survey survey){
        survey.setId(id);
        Optional<Survey> updatedSurvey = services.update(survey);
        return updatedSurvey.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        //map me permite transformar el contenido interno del optional si está presente
        //si contiene un survey se aplica ResponseEntity.ok(s); basicamente HTTP 200 OK y el cuerpo es Survey
        // orElseGet es un metodo del optional para dar valor si está vacío
        // en este caso ejecuta la funcion lambda que devuelve un ResponseEntity 404 Not Found si body
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvey(@PathVariable Integer id){
        boolean deleted = services.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        // condicion ? sitrue : sifalse
    } 

}
