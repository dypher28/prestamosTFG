package org.dam23.prestamostfg.services;

import jakarta.transaction.Transactional;
import org.dam23.prestamostfg.dtos.PaqueteDto;
import org.dam23.prestamostfg.entities.Libro;
import org.dam23.prestamostfg.entities.Paquete;
import org.dam23.prestamostfg.infos.CursoInfo;
import org.dam23.prestamostfg.infos.PaqueteInfo;
import org.dam23.prestamostfg.mappers.PaqueteMapper;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.LibroRepository;
import org.dam23.prestamostfg.repositories.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
        paquete = paqueteRepository.save(paquete);

        paquete.setLibros(libros);

        paquete = paqueteRepository.save(paquete);

        if (paquete.getId() != null) {
            return new ResponseModel(0, "Paquete creado correctamente", paquete.getId());
        }
        return new ResponseModel(1, "Error al crear el paquete", null);
    }

    public ResponseModel obtenerPaquetes() {
        List<PaqueteInfo> listaPaquetes = paqueteRepository.findAllByOrderById();
        if (!listaPaquetes.isEmpty()) {
            return new ResponseModel(0, "Lista de paquetes", listaPaquetes);
        }
        return new ResponseModel(1, "No se encontraron paquetes", null);
    }

    @Transactional
    public ResponseModel borrarPaquete(Integer idPaquete) {
        Optional<Paquete> paqueteOpt = paqueteRepository.findById(idPaquete);
        if (paqueteOpt.isEmpty()) {
            return new ResponseModel(1, "No existe ningún paquete con ID " + idPaquete, null);
        }
        Paquete paquete = paqueteOpt.get();
        // Desasociar todos los libros del paquete
        paquete.getLibros().clear();
        // Eliminar el paquete
        paqueteRepository.delete(paquete);
        return new ResponseModel(0, "El paquete ha sido borrado", null);
    }


}
