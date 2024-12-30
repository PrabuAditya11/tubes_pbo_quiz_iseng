package com.quiz.tubespbo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
<<<<<<< HEAD
@Table(name = "user")
=======
@Table(name ="user")
>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String nim;

    private String password;

<<<<<<< HEAD
    private String role;

=======
>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<QuizResult> quizResults;
}
