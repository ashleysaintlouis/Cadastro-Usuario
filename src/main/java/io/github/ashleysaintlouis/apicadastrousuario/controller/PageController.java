package io.github.ashleysaintlouis.apicadastrousuario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String loginPage() {
        return "loginUser";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "registerUser";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/server")
    public String serverPage() {
        return "server";
    }
}
