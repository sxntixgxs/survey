package com.sxntixgxs.survey.chapters.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sxntixgxs.survey.chapters.domain.models.Chapter;

import java.util.Optional;
import java.util.List;

public interface ChapterRepository extends JpaRepository<Chapter,Integer>{
    List<Chapter> findBySurveyId(Integer id);
}
