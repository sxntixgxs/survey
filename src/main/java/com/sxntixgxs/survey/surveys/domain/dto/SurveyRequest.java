package com.sxntixgxs.survey.surveys.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyRequest {
    private String name;
    private String description;
    private boolean published;
}
