package com.example.pokemonapp.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    @GetMapping("/{imageName}")
    public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
        var imgFile = new ClassPathResource("images/" + imageName);
        if (!imgFile.exists()) {
            imgFile = new ClassPathResource("images/default.png");
        }

        byte[] bytes = Files.readAllBytes(imgFile.getFile().toPath());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(bytes);
    }
}
