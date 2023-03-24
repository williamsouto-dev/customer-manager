package com.example.customermanager.adapter.out.aws.bucket;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.customermanager.application.out.IStorageServiceAdapter;
import com.example.customermanager.commons.utils.FileUtils;
import com.example.customermanager.domain.Document;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class AwsBucket implements IStorageServiceAdapter {

    private final AmazonS3 s3Client;

    @Value("${cloud.aws.bucket.name}")
    private String bucketName;

    @Value("${cloud.aws.bucket.path}")
    private String bucketPath;

    @Override
    public Document sendFile(MultipartFile file) {
        log.info("M=AwsBucket.sendFile file={}", file.getOriginalFilename());

        Document document = Document.builder()
                .storage(bucketName)
                .fileName(file.getOriginalFilename())
                .flgSend(Boolean.TRUE)
                .build();

        try {
            String hash = FileUtils.generateHashFromFile(file);
            document.setHash(hash);
            document.setPathFile(FileUtils.generatePath(bucketPath, hash));

            uploadFile(file, document);
        } catch (Exception e) {
            log.error("AwsBucket.uploadFile Error when uploading file, reason={}", e.getMessage());
            document.setFlgSend(Boolean.FALSE);
        }

        return document;
    }

    private void uploadFile(MultipartFile file, Document document) throws IOException {
        if (s3Client.doesObjectExist(bucketName, document.getPathFile())) {
            log.warn("M=AwsBucket.uploadFile File already exists in bucket");
            return;
        }

        s3Client.putObject(new PutObjectRequest(bucketName, document.getPathFile(), FileUtils.createFile(file)));
    }
}
