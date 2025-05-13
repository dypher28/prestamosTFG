package org.dam23.prestamostfg.repositories;

import org.dam23.prestamostfg.entities.Libro;
import org.dam23.prestamostfg.infos.LibroInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro, Integer> {

    List<LibroInfo> findAllBy();
    LibroInfo findLibroById(int idLibro);

    @Query("select l from Libro l where upper(l.isbn) = upper(?1)")
    LibroInfo findByIsbn(String isbn);

    @Override
    void deleteById(Integer integer);
}