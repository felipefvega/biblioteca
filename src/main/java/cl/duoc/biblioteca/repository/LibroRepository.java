package cl.duoc.biblioteca.repository;

import cl.duoc.biblioteca.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {


    Optional<Libro> findByIsbn(String isbn);

    List<Libro> findByAutorContainingIgnoreCase(String autor);
}