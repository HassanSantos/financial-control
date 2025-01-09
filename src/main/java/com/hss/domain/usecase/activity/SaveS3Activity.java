package com.hss.domain.usecase.activity;

import com.hss.FluxItem;
import com.hss.domain.usecase.context.AwsContext;
import jakarta.inject.Singleton;

import static com.hss.adapter.outbound.s3.S3Service.sendToS3Bucker;

@Singleton
public class SaveS3Activity extends FluxItem<String, AwsContext, String> {

    @Override
    public String doExecute(String sqsModelInvoice, AwsContext awsContext) {

        sendToS3Bucker("financial-control", "file.txt", awsContext.getBytesFile());
        return "";
    }


    @Override
    public String processException(String sqsModelInvoice, AwsContext unused, Exception e) {
        return "";
    }
}
