package com.example.foroHub.model.profile;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profiles")
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ProfileEnum name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProfileEnum getName() {
        return name;
    }

    public void setName(ProfileEnum name) {
        this.name = name;
    }
}
