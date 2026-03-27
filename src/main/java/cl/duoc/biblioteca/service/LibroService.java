package cl.duoc.biblioteca.service;

import cl.duoc.biblioteca.model.Libro; 
import cl.duoc.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org. springframework.stereotype.Service;
import java.util.List;

@Service

public class LibroService {

    @Autowired

    private LibroRepository libroRepository;

    public List<Libro> getLibros(){

        return libroRepository.obtenerLibros();

    }

    public Libro saveLibro(Libro libro) {

        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id) {

        return libroRepository.buscarLibroPorId(id);
    }

    public Libro getLibroPorIsbn(String isbn) {

        return libroRepository.buscarPorIsbn(isbn);
    }

    public Libro updateLibro(Libro libro){

        return libroRepository.actualizar(libro);
    }

    public String deleteLibro(int id) {

        libroRepository.eliminar(id);

        return "Producto eliminado";
    }

    public int totalLibrosV1(){

        return libroRepository.obtenerLibros().size();
    }

    public int totalLibrosV2() {
    return libroRepository.totalLibros();
    }

    public List<Libro> getLibrosPorAnio(int anio){
        return libroRepository.obtenerLibrosPorAnio(anio);
    }

}
