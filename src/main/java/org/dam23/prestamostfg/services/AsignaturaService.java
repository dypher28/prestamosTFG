package org.dam23.prestamostfg.services;

import org.dam23.prestamostfg.infos.AsignaturaInfo;
import org.dam23.prestamostfg.infos.CursoInfo;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.AsignaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    public ResponseModel obtenerLibrosPorAsignatura(Integer idAsignatura) {
        AsignaturaInfo asignatura = asignaturaRepository.findAsignaturaById(idAsignatura);

        if(asignatura == null) {
            return new ResponseModel(1, "Asignatura no encontrada", null);
        }

        if(asignatura.getLibros() == null || asignatura.getLibros().isEmpty()) {
            return new ResponseModel(1, "No se encontraron libros en esta asignatura", null);
        }

        return new ResponseModel(0, "Libros", asignatura.getLibros());
    }


}
