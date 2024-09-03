package com.sxntixgxs.survey.chapters.domain.models.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChapterRequest {
    private Date created_at;
    private String chapter_number;
    private String chapter_title;
    private Integer surveyId;
}
