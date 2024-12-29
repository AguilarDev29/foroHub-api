package com.example.foroHub.model.course.dto;

import com.example.foroHub.model.course.Course;

public record DtoCreateTopicCourse(
        Long id,
        String name
) {
    public DtoCreateTopicCourse(Course course) {
        this(course.getId(), course.getName());
    }
}
