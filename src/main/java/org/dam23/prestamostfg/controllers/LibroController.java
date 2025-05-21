package org.dam23.prestamostfg.controllers;

import org.dam23.prestamostfg.dtos.LibroDto;
import org.dam23.prestamostfg.entities.Libro;
import org.dam23.prestamostfg.mappers.LibroMapper;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.ImageRepository;
import org.dam23.prestamostfg.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Optional;

@RestController
@RequestMapping("libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @Autowired
    private LibroMapper libroMapper;

    @PostMapping("/crearLibro")
    public ResponseEntity<ResponseModel> crearLibro(@RequestBody LibroDto libroDto) {
        return ResponseEntity.ok(libroService.crearLibro(libroDto));
    }

    @GetMapping("obtenerLibros")
    public ResponseEntity<ResponseModel> obtenerLibros(){
        return ResponseEntity.ok(libroService.obtenerLibros());
    }

    @GetMapping("/existeISBN/{isbn}")
    public ResponseEntity<ResponseModel> existeIsbn(@PathVariable String isbn) {
        ResponseModel response = libroService.existeIsbn(isbn);
        return ResponseEntity.ok(response);
    }

}
