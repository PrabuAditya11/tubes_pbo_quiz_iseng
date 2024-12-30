package com.quiz.tubespbo.controller;

import jakarta.servlet.http.HttpSession;
import com.quiz.tubespbo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "index"; // Mengarah ke templates/index.html
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(HttpSession session, Model model) {
        // Pastikan user yang mengakses adalah admin
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser == null || !"admin".equals(currentUser.getRole())) {
            return "redirect:/auth/login"; // Redirect ke login jika bukan admin
        }

        model.addAttribute("user", currentUser);
        return "admin/dashboard_admin"; // Halaman dashboard admin
    }
}
