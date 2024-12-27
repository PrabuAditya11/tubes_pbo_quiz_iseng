package com.quiz.tubespbo.controller;

import com.quiz.tubespbo.model.User;
import com.quiz.tubespbo.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Menampilkan halaman login
    @GetMapping("/login")
    public String loginPage() {
        return "auth/login"; // Mengarah ke templates/auth/login.html
    }

    // Proses login
    @PostMapping("/login")
    public String login(String nim, String password, HttpSession session, Model model) {
        User user = userService.authenticate(nim, password);
        if (user != null) {
            session.setAttribute("currentUser", user);
            return "redirect:/user/dashboard"; // Redirect ke dashboard user
        } else {
            model.addAttribute("error", "Invalid NIM or Password");
            return "auth/login"; // Kembali ke halaman login dengan pesan error
        }
    }

    // Proses logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login"; // Redirect ke halaman login
    }
}

