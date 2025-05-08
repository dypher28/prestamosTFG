package org.dam23.prestamostfg.services;

import org.dam23.prestamostfg.dtos.LibroDto;
import org.dam23.prestamostfg.entities.Libro;
import org.dam23.prestamostfg.infos.CursoInfo;
import org.dam23.prestamostfg.infos.LibroInfo;
import org.dam23.prestamostfg.mappers.LibroMapper;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private LibroMapper libroMapper;

    public ResponseModel crearLibro(LibroDto libroDto) {
        Libro libro = libroMapper.toEntity(libroDto);
        Libro savedLibro = libroRepository.save(libro);

        if(savedLibro.getId() == null) {
            return new ResponseModel(1, "Error al crear el libro", null);
        }
        return new ResponseModel(0, "El libro ha sido creado", null);
    }

    public ResponseModel obtenerLibros() {
        List<LibroInfo> listaLibros = libroRepository.findAllBy();
        if (!listaLibros.isEmpty()) {
            return new ResponseModel(0, "Lista de libros", listaLibros);
        }
        return new ResponseModel(1, "No se encontraron libros", null);
    }

    public ResponseModel existeIsbn(String isbn) {
        LibroInfo libro = libroRepository.findByIsbn(isbn);
        if (libro != null) {
            return new ResponseModel(1, "El ISBN ya está registrado", true);
        } else {
            return new ResponseModel(0, "El ISBN está disponible", false);
        }
    }



}
