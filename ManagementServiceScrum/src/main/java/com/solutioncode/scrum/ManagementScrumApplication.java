package com.solutioncode.scrum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ManagementScrumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementScrumApplication.class, args);
    }

}

@RestController
@RequestMapping(value = "/")
class Prueba {
    @GetMapping
    public String saludo() {
        return "prueba";
    }
}