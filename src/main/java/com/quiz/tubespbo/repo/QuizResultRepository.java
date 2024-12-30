package com.quiz.tubespbo.repo;

import com.quiz.tubespbo.model.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {

    // Mencari hasil quiz berdasarkan User ID dan Quiz ID
    QuizResult findByUserIdAndQuizId(Long userId, Long quizId);

    // Mendapatkan leaderboard berdasarkan Quiz ID
    @Query("SELECT q FROM QuizResult q WHERE q.quiz.id = :quizId ORDER BY q.score DESC, q.timeTakenInSeconds ASC")
    List<QuizResult> findTopResultsByQuizId(@Param("quizId") Long quizId);
}
