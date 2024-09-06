package com.sxntixgxs.survey.surveys.application;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.surveys.domain.dto.SurveyRequest;
import com.sxntixgxs.survey.surveys.domain.models.Survey;
import com.sxntixgxs.survey.surveys.domain.ports.in.SurveyOperations;
import com.sxntixgxs.survey.surveys.domain.ports.out.SurveyRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class SurveyServices implements SurveyOperations{
    private final SurveyRepository repository;

    @Override
    public Survey create(Survey survey) {
        return repository.save(survey);
    }

    @Override
    public List<Survey> getAllSurveys() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getAuthorities().stream()
            .anyMatch(role -> role.getAuthority().equals("ADMIN"))){
                //admin can see all
                List<Survey> surveys = new ArrayList<>();
                repository.findAll().forEach(surveys::add);
                return surveys;
            }else{
                // only can see published surveys
                return repository.findByPublishedTrue();
            }
    }

    @Override
    public Optional<Survey> update(Survey survey) {
        Optional<Survey> surveyExists = repository.findById(survey.getId());
        if(surveyExists.isPresent()){
            return Optional.of(repository.save(survey));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Survey> surveyExists = repository.findById(id);
        if(surveyExists.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Optional<Survey> getById(Integer id) {
        return repository.findById(id);
    }
}
