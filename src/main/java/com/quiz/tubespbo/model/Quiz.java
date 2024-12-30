package com.quiz.tubespbo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
<<<<<<< HEAD
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "quiz")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
=======

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quiz")
public class Quiz {

>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;
}


=======
    private String title;  // Judul quiz (misalnya: Math Quiz, History Quiz)

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;  // Soal-soal yang ada dalam quiz
}

>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
