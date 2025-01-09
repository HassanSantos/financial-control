package com.hss.workflow.activity;

import com.hss.FluxItem;
import com.hss.domain.usecase.ReadCsvService;
import com.hss.workflow.context.AwsContext;
import jakarta.inject.Singleton;

@Singleton
public class SendToDynamondActivity extends FluxItem<String, AwsContext, String> {

    @Override
    public String doExecute(String s, AwsContext awsContext) {
        var data = ReadCsvService.buildObject(awsContext.getBytesFile());
        //TODO: Preciso configurar o Dynamond
        return "";
    }

    @Override
    public String processException(String s, AwsContext awsContext, Exception e) {
        return "";
    }
}
