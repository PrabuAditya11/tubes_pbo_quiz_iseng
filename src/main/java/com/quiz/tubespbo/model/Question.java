package com.quiz.tubespbo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
<<<<<<< HEAD
import lombok.ToString;

@Entity
@Table(name = "question")
@Data
@NoArgsConstructor
@AllArgsConstructor
=======

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "question")
>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "question_text")
    private String questionText;

    @Column(name = "correct_answer")
    private Boolean correctAnswer;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    // Getter dan Setter
}


=======
    private String questionText;  // Isi soal

    private Boolean correctAnswer;  // Jawaban yang benar (True/False)

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;  // Quiz yang terkait dengan soal ini
}
>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
