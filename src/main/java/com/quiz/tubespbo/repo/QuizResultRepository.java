package com.quiz.tubespbo.repo;

import com.quiz.tubespbo.model.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
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
=======
import org.springframework.stereotype.Repository;

@Repository
public interface QuizResultRepository extends JpaRepository<QuizResult, Long> {

    // Mencari hasil quiz berdasarkan ID user dan ID quiz
    QuizResult findByUserIdAndQuizId(Long userId, Long quizId);
}
>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
