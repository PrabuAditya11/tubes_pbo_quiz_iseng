package com.quiz.tubespbo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quiz_result")
public class QuizResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;  // User yang mengerjakan quiz

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;  // Quiz yang dikerjakan

    private int score;  // Skor yang didapat

    private LocalDateTime startTime;  // Waktu mulai quiz

    private LocalDateTime endTime;  // Waktu selesai quiz

    private long timeTakenInSeconds;  // Waktu yang dibutuhkan (dalam detik)

    @Transient
    private List<Boolean> answers;  // Jawaban user yang tidak disimpan langsung di database
}
