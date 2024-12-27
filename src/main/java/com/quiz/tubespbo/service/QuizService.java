package com.quiz.tubespbo.service;

import com.quiz.tubespbo.model.Quiz;
import com.quiz.tubespbo.repo.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    // Method to get all available quizzes
    public List<Quiz> getAvailableQuizzes() {
        return quizRepository.findAll();  // Mengambil semua quiz yang tersedia di database
    }

    // Method to get a specific quiz by its ID
    public Quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId).orElse(null);  // Mencari quiz berdasarkan ID
    }

    // Method to save a quiz
    public Quiz saveQuiz(Quiz quiz) {
        return quizRepository.save(quiz);  // Menyimpan quiz ke database
    }

    // Additional methods for handling quiz operations can be added here
}

