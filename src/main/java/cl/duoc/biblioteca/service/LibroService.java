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

    public List<Libro> getLibros() {
        // return libroRepository.obtenerLibros();
        return libroRepository.findAll();

    }

    public Libro saveLibro(Libro libro) {
        // return libroRepository.guardar(libro);
        return libroRepository.save(libro);
    }

    public Libro getLibroId(int id) {
        // return libroRepository.buscarPorId(id);
        return libroRepository.findById(id).orElse(null);
    }

    public Libro updateLibro(Libro libro) {
        // return libroRepository.actualizar(libro);
        return libroRepository.save(libro);
    }

    public String deleteLibro(int id) {
        // libroRepository.eliminar(id);
        // return "producto eliminado";
        libroRepository.deleteById(id);
        return "Libro eliminado";
    }

    // LA ACCIÓN LA HACE EL SERVICE
    public int totalLibros() {
        // return libroRepository.obtenerLibros().size();
        return (int) libroRepository.count();
    }
}
