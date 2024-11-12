package com.hss.service;

import jakarta.inject.Singleton;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

@Singleton
public record S3UploadService() {

    public void sendAllFiles() {

        File filesInPath = new File("/home/hassan/Downloads/jujutsu/compact");

        File[] files = filesInPath.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        Arrays.stream(files).forEach(this::sendFile);

    }

    public void sendFile(File file) {

        byte[] testes = null;
        S3Client.builder()
                .build().putObject(PutObjectRequest.builder()
                .bucket("expense-spreadsheet")
                        .key(file.getName())
                .build(), RequestBody.fromBytes(testes));
    }

    public void sexndFile(String fileName, byte[] bytes) {
        S3Client.builder()
                .build().putObject(PutObjectRequest.builder()
                .bucket("expense-spreadsheet")
                        .key(fileName)
                .build(), RequestBody.fromBytes(bytes));
    }
}
