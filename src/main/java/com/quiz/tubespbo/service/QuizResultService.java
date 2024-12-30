package com.quiz.tubespbo.service;

import com.quiz.tubespbo.model.Quiz;
import com.quiz.tubespbo.model.QuizResult;
import com.quiz.tubespbo.model.User;
import com.quiz.tubespbo.repo.QuizResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizResultService {

    @Autowired
    private QuizResultRepository quizResultRepository;

    public void updateQuizResult(QuizResult existingResult, int score, LocalDateTime startTime, LocalDateTime endTime, long timeTakenInSeconds, List<Boolean> answers) {
        existingResult.setScore(score);
        existingResult.setStartTime(startTime);
        existingResult.setEndTime(endTime);
        existingResult.setTimeTakenInSeconds(timeTakenInSeconds);
        existingResult.setAnswers(answers); // Simpan jawaban user selama runtime
        quizResultRepository.save(existingResult);
    }

    // Menyimpan hasil quiz ke dalam database
    public void saveQuizResult(User user, Quiz quiz, int score, LocalDateTime startTime, LocalDateTime endTime, long timeTakenInSeconds, List<Boolean> answers) {
        QuizResult newResult = new QuizResult();
        newResult.setUser(user);
        newResult.setQuiz(quiz);
        newResult.setScore(score);
        newResult.setStartTime(startTime);
        newResult.setEndTime(endTime);
        newResult.setTimeTakenInSeconds(timeTakenInSeconds);
        newResult.setAnswers(answers); // Simpan jawaban user selama runtime
        quizResultRepository.save(newResult);
    }



    // Mendapatkan hasil quiz berdasarkan ID
    public QuizResult getQuizResultById(Long id) {
        return quizResultRepository.findById(id).orElse(null);
    }

    // Mendapatkan hasil quiz berdasarkan User ID dan Quiz ID
    public QuizResult getQuizResultByUserAndQuiz(Long userId, Long quizId) {
        return quizResultRepository.findByUserIdAndQuizId(userId, quizId);
    }

    // Mendapatkan leaderboard berdasarkan Quiz ID
    public List<QuizResult> getLeaderboardByQuiz(Long quizId) {
        return quizResultRepository.findTopResultsByQuizId(quizId);
    }
}
