package com.sxntixgxs.survey.chapters.domain.ports.in;

import com.sxntixgxs.survey.chapters.domain.models.Chapter;

import java.util.List;
import java.util.Optional;

public interface ChapterOperations {
    Chapter create(Chapter chapter);
    List<Chapter> getChaptersBySurveyId(Integer id);
    Optional<Chapter> findById(Integer id);
    Optional<Chapter> update(Chapter chapter);
    boolean delete(Integer id);
}
