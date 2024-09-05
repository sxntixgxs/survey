package com.sxntixgxs.survey.surveys.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.sxntixgxs.survey.surveys.domain.models.Survey;

public interface SurveyOperations {
    Survey create(Survey survey);
    List<Survey> getAllSurveys();
    Optional<Survey> getById(Integer id);
    Optional<Survey> update(Survey survey);
    boolean delete(Integer id);
}
