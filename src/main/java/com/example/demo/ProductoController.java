package com.example.demo;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.dto.ProductoDTO;

@Controller
public class ProductoController {

    @Value("${config.usuario}")
    private String usuario;

    @Value("${config.proyecto}")
    private String proyecto;

    @ModelAttribute("productos")
    public List<ProductoDTO> listaProductos() {
        return List.of(
            new ProductoDTO(1, "Laptop", 15000.0, "Tecnologia"),
            new ProductoDTO(2, "Mouse", 250.0, "Tecnologia"),
            new ProductoDTO(3, "Cuaderno", 45.0, "Papeleria"),
            new ProductoDTO(4, "Lapiz", 8.0, "Papeleria"));
    }

    // Lista con th:each y filtro con @RequestParam
    @GetMapping("/productos")
    public String listar(@RequestParam(required = false, defaultValue = "") String categoria, Model model) {
        List<ProductoDTO> todos = listaProductos();
        if (!categoria.isEmpty()) {
            model.addAttribute("productos",
                todos.stream().filter(p -> p.getCategoria().equalsIgnoreCase(categoria)).toList());
        }
        model.addAttribute("titulo", "Lista de productos");
        model.addAttribute("usuario", usuario);
        model.addAttribute("proyecto", proyecto);
        model.addAttribute("categoria", categoria);
        return "productos";
    }

    // Detalle con @PathVariable
    @GetMapping("/productos/{id}")
    public String detalle(@PathVariable Integer id, Model model) {
        ProductoDTO encontrado = listaProductos().stream()
            .filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        model.addAttribute("producto", encontrado);
        model.addAttribute("usuario", usuario);
        return "detalle";
    }

    // Formulario con @ModelAttribute
    @GetMapping("/formulario")
    public String formulario(Model model) {
        model.addAttribute("productoDTO", new ProductoDTO());
        model.addAttribute("usuario", usuario);
        return "formulario";
    }

    @PostMapping("/formulario")
    public String recibir(@ModelAttribute("productoDTO") ProductoDTO productoDTO, Model model) {
        model.addAttribute("producto", productoDTO);
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}