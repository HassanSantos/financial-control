package com.hss.service;

import jakarta.inject.Singleton;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Singleton
public record S3UploadService() {

    public void sexndFile(String fileName, byte[] bytes, String bucket) {
        S3Client.builder()
                .build().putObject(PutObjectRequest.builder()
                .bucket(bucket)
                        .key(fileName)
                .build(), RequestBody.fromBytes(bytes));
    }
}
