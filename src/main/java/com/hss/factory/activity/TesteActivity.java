package com.hss.factory.activity;

import com.hss.exception.TesteException;
import com.hss.exception.model.ErrorException;
import com.hss.flow.FlowItem;
import com.hss.flow.model.TesteContext;
import com.hss.model.FaturaModel;
import com.hss.out.SqsService;
import com.hss.service.ReadCsvService;
import com.hss.service.S3UploadService;
import io.micronaut.http.HttpStatus;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.InputStream;
import java.util.List;

@Singleton
@RequiredArgsConstructor
public class TesteActivity extends FlowItem<InputStream, TesteContext, String> {

    private final S3UploadService s3UploadService;
    private final ReadCsvService readCsvService;

    private final ObjectMapper objectMapper;

    @Override
    public String doExecute(InputStream file, TesteContext testeContext) {


        PutObjectResponse response = null;
        try {
            List<FaturaModel> faturaModels = readCsvService.buildObject(file);

            var testess = objectMapper.writeValueAsString(faturaModels);
            SqsService.teste(testess);


            var teste = file;
//             response =  s3UploadService.sexndFile(testeContext.getFileName(), file.getBytes(), "expense-spreadsheet");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "";
    }

    @Override
    public String processException(InputStream inputTeste, TesteContext testeContext, Exception e) {
        throw new TesteException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorException.builder().code(123).messager("ok").build());
    }
}
