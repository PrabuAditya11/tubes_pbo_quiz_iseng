package com.quiz.tubespbo.service;

import com.quiz.tubespbo.model.User;
import com.quiz.tubespbo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User validateUser(String nim, String password) {
        return userRepository.findByNimAndPassword(nim, password)
                .orElse(null);
    }

    public User authenticate(String nim, String password) {
        User user = userRepository.findByNim(nim);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
<<<<<<< HEAD

    public boolean existsByNim(String nim) {
        return userRepository.findByNim(nim) != null;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}

=======
}
>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
