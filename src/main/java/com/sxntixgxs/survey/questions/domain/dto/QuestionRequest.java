package com.sxntixgxs.survey.questions.domain.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    private Date created_at;
    private String question_number;
    private String response_type;
    private String comment_question;
    private String question_text;
    private Integer chapter_id;
}
