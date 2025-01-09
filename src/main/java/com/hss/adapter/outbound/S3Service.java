package com.hss.adapter.outbound;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class S3Service {

    public static void sendToS3Bucker(String bucketName, String fileName, byte[] bytesFile) {
        S3Client s3Client = S3Client.builder().build();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();

        s3Client.putObject(putObjectRequest, RequestBody.fromBytes(bytesFile));
    }
}
