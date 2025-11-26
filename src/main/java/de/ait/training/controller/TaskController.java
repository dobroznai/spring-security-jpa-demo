package de.ait.training.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    //endpoint tasks/me
    @GetMapping("/tasks/me")
    public List<String> myTasks(@AuthenticationPrincipal UserDetails user) {
        String username = user.getUsername();
        return List.of("Задача 1 для пользователя " + username,
                "Задача 2 для пользователя " + username);
    }

    @GetMapping("/admin/info")
    public String adminInfo(@AuthenticationPrincipal UserDetails user){
        String username = user.getUsername();
        return "Информация для админа " + username;
    }

    @GetMapping("/public/info")
    public String info() {
        return "Публичная страница";
    }
}
