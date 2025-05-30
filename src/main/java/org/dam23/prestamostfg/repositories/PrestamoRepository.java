package org.dam23.prestamostfg.repositories;

import org.dam23.prestamostfg.entities.Prestamo;
import org.dam23.prestamostfg.infos.PaqueteInfo;
import org.dam23.prestamostfg.infos.PrestamoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

    List<PrestamoInfo> findAllByOrderById();
}