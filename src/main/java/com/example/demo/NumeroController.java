package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumeroController {
    @GetMapping("/semestre")
    public int semestre() {
        return 9;
    }
}