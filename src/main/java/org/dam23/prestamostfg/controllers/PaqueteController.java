package org.dam23.prestamostfg.controllers;

import org.dam23.prestamostfg.dtos.LibroDto;
import org.dam23.prestamostfg.dtos.PaqueteDto;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.services.PaqueteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

    @Autowired
    private PaqueteService paqueteService;

    @PostMapping("/crearPaquete")
    public ResponseEntity<ResponseModel> crearPaquete(@RequestBody PaqueteDto paqueteDto) {
        return ResponseEntity.ok(paqueteService.crearPaquete(paqueteDto));
    }

    @GetMapping("obtenerPaquetes")
    public ResponseEntity<ResponseModel> obtenerPaquetes(){
        return ResponseEntity.ok(paqueteService.obtenerPaquetes());
    }

    @DeleteMapping("/borrarPaquete/{idPaquete}")
    public ResponseEntity<ResponseModel> borrarPaquete(@PathVariable Integer idPaquete) {
        return ResponseEntity.ok(paqueteService.borrarPaquete(idPaquete));
    }
}
