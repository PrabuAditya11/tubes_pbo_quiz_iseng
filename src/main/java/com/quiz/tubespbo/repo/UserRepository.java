package com.quiz.tubespbo.repo;

import com.quiz.tubespbo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByNimAndPassword(String nim, String password);
    User findByNim(String nim);
}
