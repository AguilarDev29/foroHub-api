package com.example.foroHub.model.topic.dto;

import com.example.foroHub.model.answer.dto.DtoShowAnswer;
import com.example.foroHub.model.course.Course;
import com.example.foroHub.model.topic.StatusEnum;
import com.example.foroHub.model.topic.Topic;
import com.example.foroHub.model.user.User;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record DtoShowTopic(
        String title,
        String message,
        LocalDateTime creationDate,
        StatusEnum status,
        String author,
        String course,
        List<DtoShowAnswer> answers

) {
    public DtoShowTopic(Topic topic) {
        this(topic.getTitle(), topic.getMessage(), topic.getCreationDate(),
                topic.getStatus(), topic.getAuthor().getUsername(),
                topic.getCourse().getName(), topic.getAnswers().stream()
                        .map(DtoShowAnswer::new).toList());
    }
}
