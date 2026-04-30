package cl.duoc.biblioteca.controller;

import cl.duoc.biblioteca.model.Libro;
import cl.duoc.biblioteca.service.LibroService;
import jakarta.validation.Valid;
//import cl.duoc.biblioteca.dto.*;
import cl.duoc.biblioteca.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.duoc.biblioteca.dto.CreateLibroRequest;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.getLibros();
    }

    @GetMapping(params = "autor")
    public List<Libro> listarLibrosPorAutor(@RequestParam String autor) {
        

        return libroService.getLibrosPorAutor(autor);
    }


    @PostMapping
    public ResponseEntity<Libro> agregarLibro(@Valid @RequestBody CreateLibroRequest request) {
             // @Valid ejecuta validaciones Jakarta automáticamente
             // Si falla → GlobalExceptionHandler.handleValidationErrors() retorna 400

            Libro nuevoLibro = libroService.saveLibro(LibroMapper.toModel(request));
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscarLibro(@PathVariable int id) {
        Libro libro = libroService.getLibroId(id);
        
        if (libro != null) {
            
            return ResponseEntity.ok(libro); 
        } else {
            
            return ResponseEntity.notFound().build(); 
        }
    }
    

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable int id, @RequestBody Libro libro) {
        // el id lo usaremos mas adelante
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("/{id}")
    public String eliminarLibro(@PathVariable int id) {
        return libroService.deleteLibro(id);
    }

    
}
