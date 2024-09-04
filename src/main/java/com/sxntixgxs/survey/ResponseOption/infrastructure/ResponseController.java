package com.sxntixgxs.survey.ResponseOption.infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;
import java.util.List;

import com.sxntixgxs.survey.ResponseOption.application.ResponseServices;
import com.sxntixgxs.survey.ResponseOption.domain.dto.ResponseRequest;
import com.sxntixgxs.survey.ResponseOption.domain.models.ResponseOption;
import com.sxntixgxs.survey.questions.domain.Question;
import com.sxntixgxs.survey.questions.domain.ports.out.QuestionRepository;

@RestController
@RequestMapping("api/questions/responseoptions")
public class ResponseController {
    @Autowired
    private final ResponseServices services;
    @Autowired
    private final QuestionRepository questionRepository;
    public ResponseController(ResponseServices services, QuestionRepository questionRepository) {
        this.services = services;
        this.questionRepository = questionRepository;
    }
    @PostMapping
    public ResponseEntity<ResponseOption> createResponse(@RequestBody ResponseRequest request){
        Integer questionId = request.getQuestionId();
        Optional<Question> questionOptional = questionRepository.findById(questionId);
        if(questionOptional.isPresent()){
            ResponseOption response = new ResponseOption();
            response.setOption_number(request.getOption_number());
            response.setOption_text(request.getOption_text());
            response.setQuestion(questionOptional.get());
            ResponseOption createdResponse = services.create(response);
            return ResponseEntity.ok(createdResponse);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<ResponseOption>> getAllResponsesByQuestionId(@PathVariable Integer id){
        return ResponseEntity.ok(services.getAllResponsesByQuestionId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ResponseOption> updateResponse(@PathVariable Integer id, @RequestBody ResponseOption response){
        response.setId(id);
        Optional<ResponseOption> updatedResponse = services.update(response);
        return updatedResponse.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build()); 
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResponse(@PathVariable Integer id){
        boolean deleted = services.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
