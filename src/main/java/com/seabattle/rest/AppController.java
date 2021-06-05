package com.seabattle.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class AppController {

    @GetMapping()
    public String home() {
        return "home";
    }

    @GetMapping("/registration")
    public String regist() {
        return "registration";
    }

    @GetMapping("/game")
    @PreAuthorize("hasAuthority('users:read')")
    public String game() {
        return "game";
    }

    @GetMapping("/main")
    @PreAuthorize("hasAuthority('users:read')")
    public String main() {
        return "main";
    }
}
