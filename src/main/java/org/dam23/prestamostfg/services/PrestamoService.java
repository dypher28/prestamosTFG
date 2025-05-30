package org.dam23.prestamostfg.services;

import jakarta.persistence.EntityNotFoundException;
import org.dam23.prestamostfg.dtos.PrestamoDto;
import org.dam23.prestamostfg.entities.Matricula;
import org.dam23.prestamostfg.entities.Paquete;
import org.dam23.prestamostfg.entities.Prestamo;
import org.dam23.prestamostfg.infos.PaqueteInfo;
import org.dam23.prestamostfg.infos.PrestamoInfo;
import org.dam23.prestamostfg.models.ResponseModel;
import org.dam23.prestamostfg.repositories.MatriculaRepository;
import org.dam23.prestamostfg.repositories.PaqueteRepository;
import org.dam23.prestamostfg.repositories.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private PaqueteRepository paqueteRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    public ResponseModel crearPrestamos(List<PrestamoDto> prestamos) {
        try {
            for (PrestamoDto dto : prestamos) {
                Prestamo prestamo = new Prestamo();

                // Obtener el ID del paquete y buscar la entidad
                Integer paqueteId = dto.getPaquete().getId();
                Optional<Paquete> paqueteOptional = paqueteRepository.findById(paqueteId);
                if (!paqueteOptional.isPresent()) {
                    return new ResponseModel(1, "Paquete no encontrado con ID: " + paqueteId, null);
                }

                // Obtener el ID de la matrícula y buscar la entidad
                Integer matriculaId = dto.getMatricula().getId();
                Optional<Matricula> matriculaOptional = matriculaRepository.findById(matriculaId);
                if (!matriculaOptional.isPresent()) {
                    return new ResponseModel(1, "Matrícula no encontrada con ID: " + matriculaId, null);
                }

                // Asignar los datos al préstamo
                prestamo.setPaquete(paqueteOptional.get());
                prestamo.setMatricula(matriculaOptional.get());
                prestamo.setDevuelto(dto.getDevuelto());

                // Guardar el préstamo
                prestamoRepository.save(prestamo);
            }

            return new ResponseModel(0, "Préstamos creados correctamente", null);
        } catch (Exception e) {
            return new ResponseModel(1, "Error al crear préstamos: " + e.getMessage(), null);
        }
    }

    public ResponseModel obtenerPrestamos() {
        List<PrestamoInfo> listaPrestamos = prestamoRepository.findAllByOrderById();
        if (!listaPrestamos.isEmpty()) {
            return new ResponseModel(0, "Lista de prestamos", listaPrestamos);
        }
        return new ResponseModel(1, "No se encontraron presstamos", null);
    }

    public void eliminarPrestamoPorId(Integer id) {
        if (prestamoRepository.existsById(id)) {
            prestamoRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Préstamo con ID " + id + " no encontrado");
        }
    }

    public void devolverPrestamo(Integer idPrestamo) {
        Prestamo prestamo = prestamoRepository.findById(idPrestamo)
                .orElseThrow(() -> new EntityNotFoundException("Préstamo no encontrado"));

        if (prestamo.getDevuelto() != null && prestamo.getDevuelto()) {
            throw new IllegalStateException("El préstamo ya ha sido devuelto");
        }

        prestamo.setDevuelto(true);
        prestamo.setFechaDevolucion(LocalDate.now());
        prestamoRepository.save(prestamo);
    }

    public boolean paqueteTienePrestamo(Long paqueteId) {
        return prestamoRepository.existsByPaqueteId(paqueteId);
    }


}
