package com.example.foroHub.model.topic.dto;

import com.example.foroHub.model.course.Course;
import com.example.foroHub.model.topic.StatusEnum;
import com.example.foroHub.model.topic.Topic;
import com.example.foroHub.model.user.User;

import java.time.LocalDateTime;

public record DtoShowTopic(
        String title,
        String message,
        LocalDateTime creationDate,
        StatusEnum status,
        User author,
        Course course

) {
    public DtoShowTopic(Topic topic) {
        this(topic.getTitle(), topic.getMessage(), topic.getCreationDate(),
                topic.getStatus(), topic.getAuthor(), topic.getCourse());
    }
}
