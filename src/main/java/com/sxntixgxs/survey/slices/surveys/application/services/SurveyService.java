package com.sxntixgxs.survey.slices.surveys.application.services;

import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.slices.surveys.domain.ports.out.SurveyRepository;

@Service
public class SurveyService extends SurveyOperations{
    private final SurveyRepository repository;
}
