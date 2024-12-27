package com.quiz.tubespbo.repo;

import com.quiz.tubespbo.model.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {

    // Mencari hasil quiz berdasarkan ID user dan ID quiz
    QuizResult findByUserIdAndQuizId(Long userId, Long quizId);
}