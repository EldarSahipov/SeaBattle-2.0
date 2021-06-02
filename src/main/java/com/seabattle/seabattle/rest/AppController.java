package com.seabattle.seabattle.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AppController {

    @GetMapping("/registration")
    @PreAuthorize("hasAuthority('users:read')")
    public String regist() {
        return "registration";
    }
}
