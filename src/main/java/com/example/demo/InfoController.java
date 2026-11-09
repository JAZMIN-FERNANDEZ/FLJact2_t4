package com.example.demo;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/nombre")
    public String nombre() {
        return "Proyecto de Jazmín Fernández López";
    }

    @GetMapping("/materias")
    public List<String> materias() {
        return List.of("Programación Web", "PLF", "Administracion de redes");
    }

    @GetMapping("/datos")
    public Map<String, Object> datos() {
        return Map.of("nombre", "Jazmin Fernandez Lopez", "semestre", 9, "puerto", 8083);
    }
}