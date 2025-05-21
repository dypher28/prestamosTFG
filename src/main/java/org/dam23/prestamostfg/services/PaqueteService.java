package org.dam23.prestamostfg.services;

import org.dam23.prestamostfg.dtos.PaqueteDto;
import org.dam23.prestamostfg.entities.Libro;
import org.dam23.prestamostfg.entities.Paquete;
import org.dam23.prestamostfg.mappers.PaqueteMapper;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.LibroRepository;
import org.dam23.prestamostfg.repositories.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PaqueteService {

    @Autowired
    private PaqueteMapper paqueteMapper;

    @Autowired
    private PaqueteRepository paqueteRepository;

    @Autowired
    private LibroRepository libroRepository;

    public ResponseModel crearPaquete(PaqueteDto paqueteDto) {
        Paquete paquete = paqueteMapper.toEntity(paqueteDto);

        Set<Libro> libros = new HashSet<>();
        for (Libro libroDto : paquete.getLibros()) {
            Libro libro;
            if (libroDto.getId() != null) {
                libro = libroRepository.findById(libroDto.getId()).orElse(null); // busca libro existente
            } else {
                libro = libroDto; // si no tiene id, es un nuevo libro
            }
            if (libro != null) {
                libros.add(libro);
            }
        }
        paquete.setLibros(libros);

        paquete = paqueteRepository.save(paquete);

        if (paquete.getId() != null) {
            return new ResponseModel(0, "Paquete creado correctamente", paquete.getId());
        }
        return new ResponseModel(1, "Error al crear el paquete", null);
    }

}
