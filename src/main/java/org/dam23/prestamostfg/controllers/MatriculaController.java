package org.dam23.prestamostfg.controllers;

import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping("obtenerMatriculas")
    public ResponseEntity<ResponseModel> obtenerMatriculas() {
        return ResponseEntity.ok(matriculaService.obtenerMatriculas());
    }
}
