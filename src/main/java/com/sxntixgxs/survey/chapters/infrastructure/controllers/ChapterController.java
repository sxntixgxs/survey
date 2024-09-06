package com.sxntixgxs.survey.chapters.infrastructure.controllers;

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

import com.sxntixgxs.survey.chapters.application.ChapterServices;
import com.sxntixgxs.survey.chapters.domain.models.Chapter;
import com.sxntixgxs.survey.chapters.domain.models.dto.ChapterRequest;
import com.sxntixgxs.survey.surveys.domain.models.Survey;
import com.sxntixgxs.survey.surveys.domain.ports.out.SurveyRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {
    @Autowired
    private final ChapterServices services;
    @Autowired
    private final SurveyRepository surveyRepository;

    public ChapterController(ChapterServices services, SurveyRepository surveyRepository) {
        this.services = services;
        this.surveyRepository = surveyRepository;
    }
    @PostMapping()
    public ResponseEntity<Chapter> createChapter(@RequestBody ChapterRequest chapterRequest){
        Integer surveyId = chapterRequest.getSurveyId();
        Optional<Survey> surveyOptional = surveyRepository.findById(surveyId);

        if(surveyOptional.isPresent()){
            Chapter chapter = new Chapter();
            chapter.setCreated_at(chapterRequest.getCreated_at());
            chapter.setChapter_number(chapterRequest.getChapter_number());
            chapter.setChapter_title(chapterRequest.getChapter_title());
            chapter.setSurvey(surveyOptional.get());
            Chapter createdChapter = services.create(chapter);
            return ResponseEntity.ok(createdChapter);
        }else{
            return ResponseEntity.badRequest().build();
        }


    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Chapter>> getAllChaptersBySurveyId(@PathVariable Integer id){
        return ResponseEntity.ok(services.getChaptersBySurveyId(id));
    }
    @PutMapping("/{idSurvey}/{idChapter}")
    public ResponseEntity<Chapter> updateChapter(@PathVariable Integer idSurvey, @PathVariable Integer idChapter, @RequestBody ChapterRequest chapterRequest) {
        Optional<Chapter> existingChapter = services.findById(idChapter);
    
        if (existingChapter.isPresent() && existingChapter.get().getSurvey().getId() == idSurvey) {
            Chapter chapter = existingChapter.get();
            // Actualiza los campos del capítulo
            chapter.setChapter_number(chapterRequest.getChapter_number());
            chapter.setChapter_title(chapterRequest.getChapter_title());
            chapter.setCreated_at(chapterRequest.getCreated_at());
            chapter.setId(idChapter);
            chapter.setSurvey(surveyRepository.findById(idSurvey).get()); // Suponiendo que ya tienes un constructor adecuado para Survey
    
            // Guarda el capítulo actualizado
            Chapter updatedChapter = services.update(chapter).get();
            return ResponseEntity.ok(updatedChapter);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChapter(@PathVariable Integer id){
        boolean deleted = services.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
