package com.hss.controller;

import com.hss.service.ReadCsvService;
import com.hss.service.S3UploadService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.micronaut.http.server.multipart.MultipartBody;

import java.io.IOException;

@Controller
public record SendFileController(S3UploadService s3UploadService, ReadCsvService readCsvService) {

    @Get
    void teste() {
        readCsvService.testes();
        S3UploadService s3UploadService = new S3UploadService();
        s3UploadService.sendAllFiles();
    }


    @Post(consumes = MediaType.MULTIPART_FORM_DATA)
    public String post( @Part CompletedFileUpload file) throws IOException {
//        readCsvService.testes();


        S3UploadService s3UploadService = new S3UploadService();
//        s3UploadService.sendAllFiles();
        s3UploadService.sexndFile(file.getFilename(), file.getBytes());
        return null;
    }
}
