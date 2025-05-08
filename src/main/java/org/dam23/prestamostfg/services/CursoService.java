package org.dam23.prestamostfg.services;

import org.dam23.prestamostfg.infos.CursoInfo;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public ResponseModel obtenerCursos() {
        List<CursoInfo> listaCursos = cursoRepository.findAllByOrderById();
        if (!listaCursos.isEmpty()) {
            return new ResponseModel(0, "Lista de cursos", listaCursos);
        }
        return new ResponseModel(1, "No se encontraron cursos", null);
    }

    public ResponseModel obtenerAsignaturasPorCurso(Integer idCurso) {
        CursoInfo curso = cursoRepository.findCursoById(idCurso);

        if(curso == null) {
            return new ResponseModel(1, "Curso no encontrado", null);
        }

        if(curso.getAsignaturas() == null || curso.getAsignaturas().isEmpty()) {
            return new ResponseModel(1, "No se encontraron asignaturas en este curso", null);
        }

        return new ResponseModel(0, "Asignaturas", curso.getAsignaturas());
    }


}
