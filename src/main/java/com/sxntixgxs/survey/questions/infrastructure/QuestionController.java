package com.sxntixgxs.survey.questions.infrastructure;

import java.util.List;
import java.util.Optional;

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

import com.sxntixgxs.survey.chapters.domain.models.Chapter;
import com.sxntixgxs.survey.chapters.domain.ports.out.ChapterRepository;
import com.sxntixgxs.survey.questions.application.QuestionServices;
import com.sxntixgxs.survey.questions.domain.Question;
import com.sxntixgxs.survey.questions.domain.dto.QuestionRequest;

@RestController
@RequestMapping("api/questions")
public class QuestionController {
    @Autowired
    private final QuestionServices services;
    @Autowired
    private final ChapterRepository chapterRepository;
    public QuestionController(QuestionServices services, ChapterRepository chapterRepository) {
        this.services = services;
        this.chapterRepository = chapterRepository;
    }
    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionRequest questionRequest){
        Integer chapterId = questionRequest.getChapter_id();
        Optional<Chapter> chapterOptional = chapterRepository.findById(chapterId);
        if(chapterOptional.isPresent()){
            Question question = new Question();
            question.setChapter(chapterOptional.get());
            question.setComment_question(questionRequest.getComment_question());
            question.setCreated_at(questionRequest.getCreated_at());
            question.setQuestion_text(questionRequest.getQuestion_text());
            question.setResponse_type(questionRequest.getResponse_type());
            question.setQuestion_number(questionRequest.getQuestion_number());
            Question createdQuestion = services.create(question);
            return ResponseEntity.ok(createdQuestion);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Question>> getAllQuestionsByChapterId(@PathVariable Integer id){
        return ResponseEntity.ok(services.getAllQuestionsByChapterId(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable Integer id, @RequestBody Question question){
        question.setId(id);
        Optional<Question> updatedQuestion = services.update(question);
        return updatedQuestion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Integer id){
        boolean deleted = services.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    
}
