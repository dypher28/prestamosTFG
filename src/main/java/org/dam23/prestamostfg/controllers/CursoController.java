package org.dam23.prestamostfg.controllers;

import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("obtenerCursos")
    public ResponseEntity<ResponseModel> obtenerCursos(){
        return ResponseEntity.ok(cursoService.obtenerCursos());
    }
}
