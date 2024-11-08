package com.hss.controller;

import com.hss.service.ReadCsvService;
import com.hss.service.S3UploadService;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public record SendFileController(S3UploadService s3UploadService, ReadCsvService readCsvService) {

    @Get
    void teste() {
        readCsvService.testes();
        S3UploadService s3UploadService = new S3UploadService();
        s3UploadService.sendAllFiles();
    }
}
