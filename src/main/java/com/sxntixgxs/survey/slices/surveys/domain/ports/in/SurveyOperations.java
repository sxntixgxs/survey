package com.sxntixgxs.survey.slices.surveys.domain.ports.in;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sxntixgxs.survey.slices.surveys.domain.models.Survey;

@Repository
public interface SurveyOperations {
    Optional<Survey> createSurvey(Survey survey);
    Optional<Survey> getSurveyById(int id);
    Optional<Survey> updateSurvey(Survey survey);
    void deleteSurvey(int id);
    List<Survey> getAllSurvey();
}
