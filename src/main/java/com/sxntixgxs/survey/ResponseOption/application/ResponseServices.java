package com.sxntixgxs.survey.ResponseOption.application;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxntixgxs.survey.ResponseOption.domain.models.ResponseOption;
import com.sxntixgxs.survey.ResponseOption.domain.ports.in.ResponseOperations;
import com.sxntixgxs.survey.ResponseOption.domain.ports.out.ResponseRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ResponseServices implements ResponseOperations{
    @Autowired
    private final ResponseRepository repository;

    @Override
    public ResponseOption create(ResponseOption response) {
        return repository.save(response);
    }

    @Override
    public List<ResponseOption> getAllResponsesByQuestionId(Integer id) {
        List<ResponseOption> responses = new ArrayList<>();
        repository.findByQuestionId(id).forEach(responses::add);
        return responses;
    }

    @Override
    public Optional<ResponseOption> update(ResponseOption response) {
        Optional<ResponseOption> responseExists = repository.findById(response.getId());
        if(responseExists.isPresent()){
            return Optional.of(repository.save(response));
        }else{
            return Optional.empty();
        }
    }

    @Override
    public boolean delete(Integer id) {
        Optional<ResponseOption> responseExists = repository.findById(id);
        if(responseExists.isPresent()){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
    
}
