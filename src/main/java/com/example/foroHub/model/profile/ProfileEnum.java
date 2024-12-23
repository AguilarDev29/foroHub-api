package com.example.foroHub.model.profile;

import jakarta.persistence.Embeddable;

@Embeddable
public enum ProfileEnum {
    ADMIN,
    USER,
    MODERATOR,
    DEVELOPER
}
