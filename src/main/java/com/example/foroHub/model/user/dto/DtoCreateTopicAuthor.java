package com.example.foroHub.model.user.dto;

import com.example.foroHub.model.user.User;

public record DtoCreateTopicAuthor(
    Long id,
    String username
) {
    public DtoCreateTopicAuthor(User user){
        this(user.getId(), user.getUsername());
    }
}
