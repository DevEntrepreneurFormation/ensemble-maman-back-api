package com.ensemblemaman.api.controller;

import java.io.IOException;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.ensemblemaman.api.entities.File;
import com.ensemblemaman.api.service.FileService;
import java.util.List;



@RestController
@RequestMapping("files")
public class FileController {

    @Autowired
    private FileService fileService;

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        return fileService.getFile(id)
                .map(fileEntity -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.valueOf(fileEntity.getType()));
                    headers.setContentDispositionFormData("attachment", fileEntity.getName());
                    return new ResponseEntity<byte[]>(fileEntity.getData(), headers, HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }


    @PostMapping("/upload")
    public ResponseEntity<List<File>> uploadMultipleFiles(@RequestParam("files") List<MultipartFile> files) {
        try {
            List<File> storedFiles = fileService.storeFile(files);
            return ResponseEntity.ok(storedFiles);
        } catch (IOException e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRessource(@PathVariable("id") Long id) throws Exception {
        try {
            boolean delete = fileService.deleteRessource(id);
            if(delete) {
                return ResponseEntity.ok("Element bien supprime");
            } else {
                return ResponseEntity.notFound().build();

            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de la suppression de l'élément");

        }
        
    }

}
