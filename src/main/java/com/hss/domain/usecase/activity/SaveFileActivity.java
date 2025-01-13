package com.hss.domain.usecase.activity;

import com.hss.FluxItem;
import com.hss.domain.usecase.context.AwsContext;
import com.hss.domain.usecase.ports.outbound.FileService;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;


@Singleton
@RequiredArgsConstructor
public class SaveFileActivity extends FluxItem<String, AwsContext, String> {

    private final FileService fileService;

    @Override
    public String doExecute(String sqsModelInvoice, AwsContext awsContext) {
        fileService.saveFile("financial-control", "file.txt", awsContext.getBytesFile());
        return "";
    }


    @Override
    public String processException(String sqsModelInvoice, AwsContext unused, Exception e) {
        return "";
    }
}
