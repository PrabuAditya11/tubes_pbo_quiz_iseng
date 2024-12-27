package com.quiz.tubespbo.service;

import com.quiz.tubespbo.model.Quiz;
import com.quiz.tubespbo.model.QuizResult;
import com.quiz.tubespbo.model.User;
import com.quiz.tubespbo.repo.QuizResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuizResultService {

    @Autowired
    private QuizResultRepository quizResultRepository;

    // Menyimpan hasil quiz ke dalam database
    // Menyimpan hasil quiz ke dalam database
    public QuizResult saveQuizResult(User user, Quiz quiz, int score, LocalDateTime startTime, LocalDateTime endTime, long timeTakenInSeconds) {
        QuizResult newResult = new QuizResult();
        newResult.setUser(user);
        newResult.setQuiz(quiz);
        newResult.setScore(score);
        newResult.setStartTime(startTime);
        newResult.setEndTime(endTime);
        newResult.setTimeTakenInSeconds(timeTakenInSeconds);
        return quizResultRepository.save(newResult);
    }

    // Memperbarui hasil quiz yang sudah ada
    public void updateQuizResult(QuizResult existingResult, int score, LocalDateTime startTime, LocalDateTime endTime, long timeTakenInSeconds) {
        existingResult.setScore(score);
        existingResult.setStartTime(startTime);
        existingResult.setEndTime(endTime);
        existingResult.setTimeTakenInSeconds(timeTakenInSeconds);
        quizResultRepository.save(existingResult); // Update dengan menyimpan objek yang sudah diubah
    }

    // Mendapatkan hasil quiz berdasarkan ID
    public QuizResult getQuizResultById(Long id) {
        return quizResultRepository.findById(id).orElse(null);
    }

    // Mendapatkan hasil quiz berdasarkan User ID dan Quiz ID
    public QuizResult getQuizResultByUserAndQuiz(Long userId, Long quizId) {
        return quizResultRepository.findByUserIdAndQuizId(userId, quizId);
    }
}

