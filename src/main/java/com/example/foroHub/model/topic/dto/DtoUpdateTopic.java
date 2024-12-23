package com.example.foroHub.model.topic.dto;

import com.example.foroHub.model.course.Course;

public record DtoUpdateTopic(
        String title,
        String message,
        Course course
) {
}
