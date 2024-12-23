package com.example.foroHub.model.course.dto;

import com.example.foroHub.model.course.CategoryEnum;

public record DtoUpdateCourse(
        String name,
        CategoryEnum category
) {
}
