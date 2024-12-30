package com.quiz.tubespbo.service;

<<<<<<< HEAD
import com.quiz.tubespbo.model.Question;
import com.quiz.tubespbo.model.Quiz;
import com.quiz.tubespbo.repo.QuestionRepository;
=======
import com.quiz.tubespbo.model.Quiz;
>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
import com.quiz.tubespbo.repo.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

<<<<<<< HEAD
    @Autowired
    private QuestionRepository questionRepository;

    public List<Quiz> getAvailableQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId).orElse(null);
    }

    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    public void saveQuiz(Quiz quiz) {
        quizRepository.save(quiz);
    }

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    public void deleteQuestion(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    // Metode untuk menghapus quiz berdasarkan ID
    public void deleteQuizById(Long quizId) {
        quizRepository.deleteById(quizId);
    }
}
=======
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

>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
