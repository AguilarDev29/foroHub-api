package com.example.foroHub.model.topic.dto;

public record DtoCreateTopic(
        String title,
        String message,
        Long authorId,
        Long courseId
) {
}
