package com.hss.controller;

import com.hss.factory.activity.TesteDoisActivity;
import com.hss.flow.FlowExecutorImpl;
import com.hss.flow.model.TesteContext;
import com.hss.service.ReadCsvService;
import com.hss.service.S3UploadService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Part;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.CompletedFileUpload;

import java.io.IOException;
import java.io.InputStream;

@Controller
public record SendFileController(TesteDoisActivity testeDoisActivity,
                                 S3UploadService s3UploadService,
                                 ReadCsvService readCsvService,
                                 FlowExecutorImpl<InputStream, TesteContext, String> executor) {

    @Get
    void teste() {
        S3UploadService s3UploadService = new S3UploadService();
 }


    @Post(consumes = MediaType.MULTIPART_FORM_DATA)
    public String post(@Part CompletedFileUpload file) throws IOException {

        TesteContext context = TesteContext.builder().fileName("testes").build();

        String teste = executor.execute(file.getInputStream(), context);


        S3UploadService s3UploadService = new S3UploadService();
//        s3UploadService.sendAllFiles();
        s3UploadService.sexndFile(file.getFilename(), file.getBytes(),  "ver nome");
        return null;
    }
}
