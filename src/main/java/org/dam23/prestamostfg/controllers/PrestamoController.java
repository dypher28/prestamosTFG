package org.dam23.prestamostfg.controllers;

import org.dam23.prestamostfg.dtos.PrestamoDto;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @PostMapping("/crearPrestamos")
    public ResponseEntity<ResponseModel> crearPrestamos(@RequestBody List<PrestamoDto> prestamosDto) {
        return ResponseEntity.ok(prestamoService.crearPrestamos(prestamosDto));
    }

    @GetMapping("obtenerPrestamos")
    public ResponseEntity<ResponseModel> obtenerPrestamos(){
        return ResponseEntity.ok(prestamoService.obtenerPrestamos());
    }
}
