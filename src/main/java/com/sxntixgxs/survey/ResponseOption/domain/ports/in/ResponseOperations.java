package com.sxntixgxs.survey.ResponseOption.domain.ports.in;


import java.util.List;
import java.util.Optional;

import com.sxntixgxs.survey.ResponseOption.domain.models.ResponseOption;

public interface ResponseOperations {
    ResponseOption create(ResponseOption response);
    List<ResponseOption> getAllResponsesByQuestionId(Integer id);
    Optional<ResponseOption> update(ResponseOption response);
    boolean delete(Integer id);
}
