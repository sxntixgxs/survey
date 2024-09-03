package com.sxntixgxs.survey.questions.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.sxntixgxs.survey.questions.domain.Question;

public interface QuestionOperations {
    Question create(Question question);
    List<Question> getAllQuestionsByChapterId(Integer id);
    Optional<Question> update(Question question);
    boolean delete(Integer id);
}
