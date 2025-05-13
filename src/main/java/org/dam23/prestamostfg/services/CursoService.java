package org.dam23.prestamostfg.services;

import org.dam23.prestamostfg.infos.CursoInfo;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

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

    // Metodo para obtener las asignaturas por orden alfabetico segun el curso seleccionado
    public ResponseModel obtenerAsignaturasPorCurso(Integer idCurso) {
        CursoInfo curso = cursoRepository.findCursoById(idCurso);

        if (curso == null) {
            return new ResponseModel(1, "Curso no encontrado", null);
        }

        Set<CursoInfo.AsignaturaInfo> asignaturasSet = curso.getAsignaturas();

        if (asignaturasSet == null || asignaturasSet.isEmpty()) {
            return new ResponseModel(1, "No se encontraron asignaturas en este curso", null);
        }

        // Convertir a lista y ordenar alfabéticamente por nombre
        List<CursoInfo.AsignaturaInfo> asignaturasOrdenadas = new ArrayList<>(asignaturasSet);
        asignaturasOrdenadas.sort(Comparator.comparing(CursoInfo.AsignaturaInfo::getNombre));

        return new ResponseModel(0, "Asignaturas ordenadas", asignaturasOrdenadas);
    }


}
