# 🔐 Spring Security 

> Flux d'authentification personnalisé avec formulaire HTML, gestion des erreurs et redirections — **Spring Boot 3 + Spring Security + Thymeleaf**

![Java](https://img.shields.io/badge/Java-17+-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3-brightgreen?style=flat-square&logo=springboot)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6.x-darkgreen?style=flat-square&logo=springsecurity)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.x-green?style=flat-square)

---

## 📋 Description

Ce TP fait suite au TP1 (authentification en mémoire) et se concentre sur la **personnalisation du flux d'authentification** :
- URL de traitement du login : `/authenticate`
- Redirections après succès ou échec
- Page de déconnexion propre
- Page d'accès refusé (403)

---

## Resultat et Apperçu 
<img width="1919" height="927" alt="Capture d&#39;écran 2026-03-22 183025" src="https://github.com/user-attachments/assets/b0c77156-0654-4dab-968b-eea780ab3cab" />
<img width="1919" height="875" alt="Capture d&#39;écran 2026-03-22 183033" src="https://github.com/user-attachments/assets/5a6e7e99-5aaa-47f5-8a33-3f644ca0f113" />


## 🔄 Flux d'authentification
```
Utilisateur accède à /home
        ↓
Spring Security intercepte
        ↓
Redirection vers /login
        ↓
Formulaire POST vers /authenticate
        ↓
Spring vérifie les identifiants
        ↓
✅ Succès → /home
❌ Échec  → /login?error=true
```

---

## ✨ Fonctionnalités

- 🔐 Formulaire de login avec action sur `/authenticate`
- ✅ Redirection vers `/home` après connexion réussie
- ❌ Message d'erreur si identifiants incorrects
- 🚪 Déconnexion avec message de confirmation
- 🚫 Page 403 pour les accès non autorisés
- 👤 Rôle **USER** → `/user/dashboard`
- 🔑 Rôle **ADMIN** → `/admin/dashboard`

---

## 🏗️ Structure du projet
```
src/main/java/ma/fstg/security/
├── config/
│   └── SecurityConfig.java       # Règles de sécurité + flux d'authentification
├── web/
│   └── AuthController.java       # Contrôleur des vues
└── SpringSecurityTp2Application.java

src/main/resources/templates/
├── login.html                    # Formulaire de connexion
├── home.html                     # Page d'accueil post-connexion
├── user-dashboard.html           # Espace utilisateur
├── admin-dashboard.html          # Espace administrateur
└── access-denied.html            # Page 403
```

---

## 🛠️ Technologies

| Technologie | Rôle |
|---|---|
| Spring Boot 3.3 | Framework principal |
| Spring Security 6 | Authentification & autorisation |
| Thymeleaf | Templates HTML |
| DevTools | Rechargement automatique |
| Maven | Gestion des dépendances |

---

## ⚙️ Prérequis

- ✅ JDK 17+
- ✅ Maven 3.x
- ✅ IntelliJ IDEA
- ❌ Pas besoin de MySQL

---

## 🚀 Lancement
```bash
git clone https://github.com/ton-username/spring-security-tp2.git
cd spring-security-tp2
mvn spring-boot:run
```

Puis ouvre :
```
http://localhost:8080/login
```

---

## 🧪 Comptes de test

| Utilisateur | Mot de passe | Rôle | Accès |
|---|---|---|---|
| `user` | `1111` | USER | `/home`, `/user/dashboard` |
| `admin` | `1234` | ADMIN | Toutes les pages |

---

## 🔄 Comportements attendus

| Action | Résultat |
|---|---|
| Accès sans login | Redirige vers `/login` |
| Connexion réussie | Redirige vers `/home` |
| Mauvais mot de passe | `/login?error=true` → message rouge |
| Déconnexion | `/login?logout=true` → message vert |
| USER tente `/admin/dashboard` | Page 403 |

---

## 🔑 Points clés de la configuration
```java
.formLogin(form -> form
    .loginPage("/login")
    .loginProcessingUrl("/authenticate")  // URL interceptée par Spring
    .defaultSuccessUrl("/home", true)     // Redirection après succès
    .failureUrl("/login?error=true")      // Redirection après échec
)
.logout(logout -> logout
    .logoutUrl("/logout")
    .logoutSuccessUrl("/login?logout=true")
)
```

---

## 👨‍💻 Auteur

**Ayoub**
TP2 Spring Security — Flux d'authentification personnalisé

---

> ⚠️ `{noop}` = pas d'encodage. En production, utiliser `BCryptPasswordEncoder`.
