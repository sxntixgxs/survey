package com.sxntixgxs.survey.chapters.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.chapters.domain.models.Chapter;
import com.sxntixgxs.survey.chapters.domain.ports.in.ChapterOperations;
import com.sxntixgxs.survey.chapters.domain.ports.out.ChapterRepository;
import com.sxntixgxs.survey.surveys.domain.models.Survey;
import com.sxntixgxs.survey.surveys.domain.ports.out.SurveyRepository;

import lombok.AllArgsConstructor;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ChapterServices implements ChapterOperations{
    @Autowired
    private final ChapterRepository repository;

    @Override
    public Chapter create(Chapter chapter) {
        return repository.save(chapter);
    }

    @Override
    public List<Chapter> getChaptersBySurveyId(Integer id) {
        List<Chapter> chapters = new ArrayList<>();
        repository.findBySurveyId(id).forEach(chapters::add);
        return chapters;
    }

    @Override
    public Optional<Chapter> update(Chapter chapter) {
        Optional<Chapter> chapterExists = repository.findById(chapter.getId());
        if(chapterExists.isPresent()){
            return Optional.of(repository.save(chapter));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Chapter> chapterExists = repository.findById(id);
        if(chapterExists.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Optional<Chapter> findById(Integer id) {
        return repository.findById(id);
    }
}
