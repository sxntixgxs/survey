package com.sxntixgxs.survey.slices.surveys.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.slices.surveys.domain.models.Survey;
import com.sxntixgxs.survey.slices.surveys.domain.ports.in.SurveyOperations;
import com.sxntixgxs.survey.slices.surveys.domain.ports.out.SurveyRepository;

@Service
public class SurveyService implements SurveyOperations{
    private final SurveyRepository repository;

    public SurveyService(SurveyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Survey> createSurvey(Survey survey) {
        if(
            repository.existsById(survey.getId())
        ){
            return Optional.of(repository.save(survey));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Survey> getSurveyById(int id) {
        if(
            repository.existsById(id)
        ){
            return Optional.of(repository.findById(id).get());
        }else{
            return Optional.empty();
        }
    }

    @Override
    public Optional<Survey> updateSurvey(Survey survey) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSurvey'");
    }

    @Override
    public void deleteSurvey(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteSurvey'");
    }

    @Override
    public List<Survey> getAllSurvey() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllSurvey'");
    }
}
