package com.sxntixgxs.survey.ResponseOption.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseRequest {
    private String option_text;
    private String option_number;
    private Integer questionId;
}
