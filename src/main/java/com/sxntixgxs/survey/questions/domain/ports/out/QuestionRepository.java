package com.sxntixgxs.survey.questions.domain.ports.out;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxntixgxs.survey.questions.domain.Question;

public interface QuestionRepository extends JpaRepository<Question,Integer>{
    List<Question> findByChapterId(Integer id);
}
