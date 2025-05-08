package org.dam23.prestamostfg.repositories;

import org.dam23.prestamostfg.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}