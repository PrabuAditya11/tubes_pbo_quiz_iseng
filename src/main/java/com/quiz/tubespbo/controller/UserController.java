package com.quiz.tubespbo.controller;

import com.quiz.tubespbo.model.User;
import com.quiz.tubespbo.service.QuizService;
import com.quiz.tubespbo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuizService quizService;

    @GetMapping("/dashboard")
    public String userDashboard(HttpSession session, Model model) {
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null) {
<<<<<<< HEAD
            return "redirect:/auth/login"; // Redirect ke login jika tidak ada session
        }

        if ("admin".equals(currentUser.getRole())) {
            return "redirect:/admin/dashboard_admin"; // Redirect ke dashboard admin jika admin
=======
            return "redirect:/auth/login"; // Arahkan ke login jika tidak ada session
>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
        }

        model.addAttribute("user", currentUser);  // Menambahkan user ke model
        model.addAttribute("quizzes", quizService.getAvailableQuizzes()); // Menambahkan quiz ke model
<<<<<<< HEAD
        return "user/dashboard"; // Redirect ke dashboard user
    }


=======
        return "user/dashboard";  // Pastikan halaman dashboard.html ada
    }

>>>>>>> bdd45504ab828288b25d6a96a43ccb3f6ccff712
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Menghapus session saat logout
        return "redirect:/auth/login";  // Mengarahkan ke halaman login
    }
}

