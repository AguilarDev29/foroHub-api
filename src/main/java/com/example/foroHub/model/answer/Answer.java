package com.example.foroHub.model.answer;

import com.example.foroHub.model.topic.Topic;
import com.example.foroHub.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    private String solution;
}
