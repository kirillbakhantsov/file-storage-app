package com.example.filestorage.controller;

import com.example.filestorage.model.FileEntity;
import com.example.filestorage.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filestorage")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/create")
    public ResponseEntity<?> createFile(@RequestBody FileEntity fileEntity) {
        Long id = fileService.saveFile(fileEntity).getId();
        return ResponseEntity.ok().body("File created with ID: " + id);
    }

    @GetMapping("/{id}")
    public Optional<FileEntity> getFile(@PathVariable Long id) {
        return fileService.getFile(id);
    }

    @GetMapping
    public List<FileEntity> getAllFiles() {
        return fileService.getAllFiles();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFile(@PathVariable Long id, @RequestBody FileEntity fileEntity) {
        Optional<FileEntity> existingFile = fileService.getFile(id);
        if (existingFile.isPresent()) {
            fileEntity.setId(id);
            fileService.saveFile(fileEntity);
            return ResponseEntity.ok().body("File updated with ID: " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


