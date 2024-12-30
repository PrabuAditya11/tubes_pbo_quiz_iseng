package com.quiz.tubespbo.repo;

import com.quiz.tubespbo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // JpaRepository secara otomatis menyediakan metode seperti findById, findAll, save, deleteById, dll.
}
