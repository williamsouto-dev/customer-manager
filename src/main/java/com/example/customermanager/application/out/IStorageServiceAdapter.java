package com.example.customermanager.application.out;

import com.example.customermanager.domain.Document;
import org.springframework.web.multipart.MultipartFile;

public interface IStorageServiceAdapter {

    Document sendFile(MultipartFile file);
}
