package com.hss.entrypoint.s3;

import jakarta.inject.Singleton;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

@Singleton
public record S3UploadService() {

    public  static PutObjectResponse sexndFile(String fileName, byte[] bytes, String bucket) {
        return S3Client.builder()
                .build()
                .putObject(PutObjectRequest.builder()
                        .bucket(bucket)
                        .key(fileName)
                        .build(), RequestBody.fromBytes(bytes));
    }
}
