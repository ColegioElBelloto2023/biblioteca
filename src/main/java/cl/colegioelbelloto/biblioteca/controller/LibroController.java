package cl.colegioelbelloto.biblioteca.controller;

import cl.colegioelbelloto.biblioteca.model.Libro;
import cl.colegioelbelloto.biblioteca.service.GoogleBooksService;
import cl.colegioelbelloto.biblioteca.service.LibroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    LibroServiceImpl libroService;


    @GetMapping("/inicio")
    public String irInicio(){
        return "index";
    }


    @PostMapping("/guardar")
    public String guardarLibro(@ModelAttribute Libro libro, Model model) {
        try {
            libroService.saveLibro(libro);
            model.addAttribute("mensaje", "Libro guardado exitosamente");
            model.addAttribute("libro", new Libro()); // Limpia el formulario
            return "libro_form";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar: " + e.getMessage());
            return "libro_form";
        }
    }

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("libro", new Libro());
        return "libro_form";
    }

}
