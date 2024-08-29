package com.sxntixgxs.survey.slices.surveys.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sxntixgxs.survey.slices.surveys.domain.models.Survey;
import java.util.List;
import java.util.Optional;


public interface SurveyRepository extends JpaRepository<Survey,Integer> {
    List<Survey> findByName(String name);
    Optional<Survey> getSurveyById(int id);
    Optional<Survey> updateSurvey(Survey survey);
    Optional<Survey> deleteSurvey(int id);
}
