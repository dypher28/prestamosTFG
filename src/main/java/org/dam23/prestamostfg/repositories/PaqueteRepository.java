package org.dam23.prestamostfg.repositories;

import org.dam23.prestamostfg.entities.Paquete;
import org.dam23.prestamostfg.infos.PaqueteInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {

    List<PaqueteInfo> findAllByOrderById();

    @Override
    void deleteById(Integer integer);
}