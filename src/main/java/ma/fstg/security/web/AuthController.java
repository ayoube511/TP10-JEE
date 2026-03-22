package ma.fstg.security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    // Page de connexion personnalisée
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Page d'accueil après connexion réussie
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    // Espace administrateur — rôle ADMIN uniquement
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    // Espace utilisateur — rôles USER et ADMIN
    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "user-dashboard";
    }

    // Page d'accès refusé (403)
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }
}
