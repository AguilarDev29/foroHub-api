package com.example.foroHub.model.answer.dto;

import com.example.foroHub.model.answer.Answer;

public record DtoUpdateAnswer(
        String message
) {
    public DtoUpdateAnswer(Answer answer){
        this(answer.getMessage());
    }
}
