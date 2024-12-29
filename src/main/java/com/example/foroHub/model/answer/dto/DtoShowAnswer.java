package com.example.foroHub.model.answer.dto;

import com.example.foroHub.model.answer.Answer;

public record DtoShowAnswer(
        Long id,
        String message,
        String author,
        String topic
) {
    public DtoShowAnswer(Answer answer){
            this(answer.getId(), answer.getMessage(),
                answer.getAuthor().getUsername(),
                answer.getTopic().getTitle());
    }
}
