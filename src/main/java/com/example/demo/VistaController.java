package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VistaController {

    @GetMapping("/vista")
    public String vista(Model modelo) {
        modelo.addAttribute("titulo", "Servidor en línea");
        modelo.addAttribute("nombre", "Jazmin Fernandez Lopez");
        modelo.addAttribute("puerto", 8083);
        return "vista";
    }
}