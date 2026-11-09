package com.example.demo;

import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.ProductoDTO;

@RestController
@RequestMapping("/api")
public class ProductoRestController {

    @PostMapping("/productos")
    public ProductoDTO crear(@RequestBody ProductoDTO producto) {
        return producto;
    }
}