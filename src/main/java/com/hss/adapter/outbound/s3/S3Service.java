package com.hss.adapter.outbound.s3;

import com.hss.domain.usecase.ports.outbound.FileService;
import jakarta.inject.Singleton;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Singleton
public class S3Service implements FileService {

    public void saveFile(String bucketName, String fileName, byte[] bytesFile) {
        S3Client s3Client = S3Client.builder().build();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();
        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(bytesFile));
    }
}
