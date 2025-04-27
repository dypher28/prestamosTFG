package org.dam23.prestamostfg.controllers;

import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.services.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/obtenerAlumnos")
    public ResponseEntity<ResponseModel> obtenerAlumnos() {
        return ResponseEntity.ok(alumnoService.obtenerAlumnos());
    }
}
