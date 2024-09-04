package com.sxntixgxs.survey.ResponseOption.domain.ports.out;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sxntixgxs.survey.ResponseOption.domain.models.ResponseOption;

import java.util.List;

public interface ResponseRepository extends JpaRepository<ResponseOption,Integer>{
    List<ResponseOption> findByQuestionId(Integer id);
}
