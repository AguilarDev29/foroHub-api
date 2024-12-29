package com.example.foroHub.model.topic.dto;

import com.example.foroHub.model.course.dto.DtoCreateTopicCourse;
import com.example.foroHub.model.topic.Topic;
import com.example.foroHub.model.user.dto.DtoCreateTopicAuthor;

public record DtoCreateTopic(
        String title,
        String message,
        DtoCreateTopicAuthor author,
        DtoCreateTopicCourse course
) {
    public DtoCreateTopic(Topic topic) {
        this(topic.getTitle(), topic.getMessage(), new DtoCreateTopicAuthor(topic.getAuthor()), new DtoCreateTopicCourse(topic.getCourse()));
    }
}
