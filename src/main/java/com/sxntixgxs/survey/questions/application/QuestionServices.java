package com.sxntixgxs.survey.questions.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.questions.domain.Question;
import com.sxntixgxs.survey.questions.domain.ports.in.QuestionOperations;
import com.sxntixgxs.survey.questions.domain.ports.out.QuestionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionServices implements QuestionOperations{
    @Autowired
    private final QuestionRepository repository;

    @Override
    public Question create(Question question) {
        return repository.save(question);
    }

    @Override
    public List<Question> getAllQuestionsByChapterId(Integer id) {
        List<Question> questions = new ArrayList<>();
        repository.findByChapterId(id).forEach(questions::add);
        return questions;
    }

    @Override
    public Optional<Question> update(Question question) {
        Optional<Question> questionExists = repository.findById(question.getId());
        if(questionExists.isPresent()){
            return Optional.of(repository.save(question));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Question> questionExists = repository.findById(id);
        if(questionExists.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }




}
