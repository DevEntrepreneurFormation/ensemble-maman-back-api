package com.ensemblemaman.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ensemblemaman.api.entities.File;
import com.ensemblemaman.api.repository.FileRepository;

import java.io.IOException;
import java.util.Optional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;

    public File saveFile(MultipartFile file) throws IOException {
        File fileEntity = new File();
        fileEntity.setName(file.getOriginalFilename());
        fileEntity.setType(file.getContentType());
        fileEntity.setData(file.getBytes());

        return fileRepository.save(fileEntity);
    }

    public Optional<File> getFile(Long id) {
        return fileRepository.findById(id);
    }


    public List<File> storeFile(List<MultipartFile> files) throws IOException {
        return files.stream().map(file -> {
            try {
                return saveFile(file);
            } catch (IOException e) {
                throw new RuntimeException("Failed to store file", e);
            }
        }).collect(Collectors.toList());
    }


    public boolean deleteRessource(Long id){
            fileRepository.deleteById(id);
            return true;       
    };

}
