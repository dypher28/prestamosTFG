package org.dam23.prestamostfg.controllers;

import org.dam23.prestamostfg.repositories.ImageRepository;
import org.dam23.prestamostfg.entities.Image;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageRepository imageRepo;

    public ImageController(ImageRepository imageRepo) {
        this.imageRepo = imageRepo;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            Image img = new Image();
            img.setFileName(file.getOriginalFilename());
            img.setContentType(file.getContentType());
            img.setData(file.getBytes());
            img = imageRepo.save(img);
            return ResponseEntity.ok(img.getId().toString());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al leer el archivo");
        }
    }
}
