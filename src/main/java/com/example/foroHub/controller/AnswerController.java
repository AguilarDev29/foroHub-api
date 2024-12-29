package com.example.foroHub.controller;

import com.example.foroHub.model.answer.Answer;
import com.example.foroHub.model.answer.dto.DtoShowAnswer;
import com.example.foroHub.model.answer.dto.DtoUpdateAnswer;
import com.example.foroHub.service.AnswerService;
import com.jogamp.common.net.Uri;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }
    @GetMapping
    public ResponseEntity<Page<DtoShowAnswer>> findAllAnswers(@PageableDefault(size = 10) Pageable pageable){
        return ResponseEntity.ok(answerService.findAllAnswers(pageable).map(DtoShowAnswer::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoShowAnswer> findAnswerById(@PathVariable Long id){
        var optionalAnswer = answerService.getAnswer(id);
        if(optionalAnswer.isPresent()){
            var answer = optionalAnswer.get();
            answerService.getAnswer(answer.getId());
            return ResponseEntity.ok(new DtoShowAnswer(answer));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<DtoShowAnswer> createAnswer(@RequestBody Answer answer){
        answerService.saveAnswer(answer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(answer.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new DtoShowAnswer(answer));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable Long id, @RequestBody DtoUpdateAnswer data){
        var optionalAnswer = answerService.getAnswer(id);
        if(optionalAnswer.isPresent()){
            var answer = optionalAnswer.get();
            answerService.updateAnswer(answer, data);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long id){
        var optionalAnswer = answerService.getAnswer(id);
        if(optionalAnswer.isPresent()){
            var answer = optionalAnswer.get();
            answerService.deleteAnswer(answer.getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}