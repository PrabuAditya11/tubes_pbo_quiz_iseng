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

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @PostMapping("/login")
    public String login(String nim, String password, HttpSession session, Model model) {
        User user = userService.authenticate(nim, password);
        if (user != null) {
            session.setAttribute("currentUser", user);

            // Redirect berdasarkan role
            if ("admin".equals(user.getRole())) {
                return "admin/dashboard_admin"; // Admin dashboard
            } else {
                return "redirect:/user/dashboard"; // User dashboard
            }
        } else {
            model.addAttribute("error", "Invalid NIM or Password");
            return "auth/login"; // Kembali ke halaman login dengan pesan error
        }
    }



    @GetMapping("/register")
    public String registerPage() {
        return "auth/register"; // Mengarah ke templates/auth/register.html
    }

    @PostMapping("/register")
    public String register(String name, String nim, String password, String role, Model model) {
        if (userService.existsByNim(nim)) {
            model.addAttribute("error", "NIM already exists");
            return "auth/register";
        }

        User user = new User();
        user.setName(name);
        user.setNim(nim);
        user.setPassword(password);
        user.setRole(role);
        userService.saveUser(user);

        return "redirect:/auth/login"; // Redirect ke halaman login
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/auth/login";
    }
}


