package com.hss.controller;

import com.hss.service.S3UploadService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public record SendFileController(S3UploadService s3UploadService) {

    @Get
    void teste() {
        S3UploadService s3UploadService = new S3UploadService();
        s3UploadService.sendAllFiles();
    }
}
