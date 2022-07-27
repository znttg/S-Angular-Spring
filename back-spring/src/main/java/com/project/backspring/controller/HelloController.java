package com.project.backspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Indica como a API seja acessada
@RequestMapping("/api/hello")
public class HelloController {

    // Gera o retorono para o metodo GET
    @GetMapping
    public String hello() {
        return "Hello, World!";
    }
}
