package com.quiz.tubespbo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nim;

    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<QuizResult> quizResults;
}
