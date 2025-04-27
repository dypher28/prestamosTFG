package org.dam23.prestamostfg.services;

import org.dam23.prestamostfg.infos.AlumnoInfo;
import org.dam23.prestamostfg.infos.AsignaturaInfo;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public ResponseModel obtenerAlumnos() {
        List<AlumnoInfo> listaAlumnos = alumnoRepository.findAllBy();
        if (!listaAlumnos.isEmpty()) {
            return new ResponseModel(0, "Lista de alumnos", listaAlumnos);
        }
        return new ResponseModel(1, "No se encontraron alumnos", null);
    }
}
