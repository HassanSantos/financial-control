package com.hss.config.bean;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sqs.SqsClient;

@Factory
public class SqsBean {

    @Bean
    public SqsClient getSqs() {
        return SqsClient.builder().build();
    }

    @Bean
    public S3Client getS3() {
        return S3Client.builder().build();
    }
}
