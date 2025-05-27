package org.dam23.prestamostfg.services;

import jakarta.transaction.Transactional;
import org.dam23.prestamostfg.dtos.LibroDto;
import org.dam23.prestamostfg.entities.Libro;
import org.dam23.prestamostfg.entities.Paquete;
import org.dam23.prestamostfg.infos.CursoInfo;
import org.dam23.prestamostfg.infos.LibroInfo;
import org.dam23.prestamostfg.mappers.LibroMapper;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private LibroMapper libroMapper;

    // Metodo para crear libros
    public ResponseModel crearLibro(LibroDto libroDto) {
        Libro libro = libroMapper.toEntity(libroDto);
        Libro savedLibro = libroRepository.save(libro);

        if(savedLibro.getId() == null) {
            return new ResponseModel(1, "Error al crear el libro", null);
        }
        return new ResponseModel(0, "El libro ha sido creado", null);
    }

    // Metodo para obtener todos los libros
    public ResponseModel obtenerLibros() {
        List<LibroInfo> listaLibros = libroRepository.findAllBy();
        if (!listaLibros.isEmpty()) {
            return new ResponseModel(0, "Lista de libros", listaLibros);
        }
        return new ResponseModel(1, "No se encontraron libros", null);
    }

    // Metodo para comprobar si existe ISBN
    public ResponseModel existeIsbn(String isbn) {
        LibroInfo libro = libroRepository.findByIsbn(isbn);
        if (libro != null) {
            return new ResponseModel(1, "El ISBN ya está registrado", true);
        } else {
            return new ResponseModel(0, "El ISBN está disponible", false);
        }
    }

    // Metodo para borrar un libro
    @Transactional
    public ResponseModel borrarLibro(Integer idLibro) {
        // 1. Buscar el libro por su ID
        Optional<Libro> libroOpt = libroRepository.findById(idLibro);
        if (libroOpt.isEmpty()) {
            return new ResponseModel(1, "No existe ningún libro con ID " + idLibro, null);
        }

        Libro libro = libroOpt.get();

        // 2. Recorrer todos los paquetes asociados y desasociar el libro
        for (Paquete paquete : libro.getPaquetes()) {
            paquete.getLibros().remove(libro);

        }

        // 3. Borrar el libro (ahora no hay ninguna FK directa que impida el DELETE)
        libroRepository.delete(libro);

        return new ResponseModel(0, "El libro ha sido borrado", null);
    }

}
