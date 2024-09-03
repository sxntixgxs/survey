package com.sxntixgxs.survey.surveys.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sxntixgxs.survey.surveys.domain.models.Survey;

public interface SurveyRepository extends CrudRepository<Survey,Integer>{

}
