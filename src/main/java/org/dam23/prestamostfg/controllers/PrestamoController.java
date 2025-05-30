package org.dam23.prestamostfg.controllers;

import jakarta.persistence.EntityNotFoundException;
import org.dam23.prestamostfg.dtos.PrestamoDto;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("borrarPrestamo/{id}")
    public ResponseEntity<ResponseModel> eliminarPrestamo(@PathVariable Integer id) {
        try {
            prestamoService.eliminarPrestamoPorId(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("devolver/{id}")
    public ResponseEntity<?> devolverPrestamo(@PathVariable Integer id) {
        try {
            prestamoService.devolverPrestamo(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Préstamo no encontrado");
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/paqueteTienePrestamo/{id}")
    public ResponseEntity<ResponseModel> verificarPaqueteTienePrestamo(@PathVariable Long id) {
        boolean tienePrestamo = prestamoService.paqueteTienePrestamo(id);

        ResponseModel response = new ResponseModel();
        response.setSuccess(0);
        response.setData(tienePrestamo);

        return ResponseEntity.ok(response);
    }

}
