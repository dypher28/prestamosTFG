package org.dam23.prestamostfg.repositories;

import org.dam23.prestamostfg.entities.Paquete;
import org.dam23.prestamostfg.infos.PaqueteInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {

    List<PaqueteInfo> findAllByOrderById();

    @Query("select p from Paquete p where upper(p.nombre) like upper(concat('%', ?1, '%'))")
    List<PaqueteInfo> findByName(String nombre);


    @Override
    void deleteById(Integer integer);
}