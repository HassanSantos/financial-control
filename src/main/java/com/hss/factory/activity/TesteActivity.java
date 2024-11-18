package com.hss.factory.activity;

import com.hss.flow.FlowItem;
import com.hss.flow.model.TesteContext;
import com.hss.service.S3UploadService;
import jakarta.inject.Singleton;

@Singleton
public class TesteActivity extends FlowItem<String, TesteContext, String> {

    @Override
    public String doExecute(String file, TesteContext testeContext) {


        S3UploadService s3UploadService = new S3UploadService();
//        s3UploadService.sendAllFiles();
        try {
            s3UploadService.sexndFile(testeContext.getFileName(), file.getBytes(),  "ver nome");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    @Override
    public String processException(String inputTeste, TesteContext testeContext, Exception e) {
        return "";
    }
}
