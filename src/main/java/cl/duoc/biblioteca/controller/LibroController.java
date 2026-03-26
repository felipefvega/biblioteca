package cl.duoc.biblioteca.controller;

import cl.duoc.biblioteca.model.Libro;
import cl.duoc.biblioteca.service.LibroService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.getLibros();

    }

    @PostMapping

    public Libro  agregarLibro(@RequestBody Libro Libro) {
        return libroService.saveLibro(Libro);
    
    }

}
