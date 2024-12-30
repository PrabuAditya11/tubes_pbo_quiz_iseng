package com.quiz.tubespbo.service;

import com.quiz.tubespbo.model.Question;
import com.quiz.tubespbo.model.Quiz;
import com.quiz.tubespbo.repo.QuestionRepository;
import com.quiz.tubespbo.repo.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

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
