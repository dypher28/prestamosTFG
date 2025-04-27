package org.dam23.prestamostfg.controllers;

import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping("/obtenerAsignaturas")
    public ResponseEntity<ResponseModel> obtenerAsignaturas() {
        return ResponseEntity.ok(asignaturaService.obtenerAsignaturas());
    }
}
