package org.dam23.prestamostfg.services;

import org.dam23.prestamostfg.infos.CursoInfo;
import org.dam23.prestamostfg.infos.MatriculaInfo;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public ResponseModel obtenerMatriculas() {
        List<MatriculaInfo> listaMatriculas = matriculaRepository.findAllByOrderById();
        if (!listaMatriculas.isEmpty()) {
            return new ResponseModel(0, "Lista de matriculas", listaMatriculas);
        }
        return new ResponseModel(1, "No se encontraron matriculas", null);
    }

    public List<MatriculaInfo> buscarPorNombreOApellido(String filtro) {
        return matriculaRepository.findByAlumno_NombreContainsIgnoreCaseOrAlumno_ApellidosContainsIgnoreCase(filtro, filtro);
    }
}
