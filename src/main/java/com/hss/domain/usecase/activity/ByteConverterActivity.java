package com.hss.domain.usecase.activity;

import com.hss.FluxItem;
import com.hss.domain.usecase.context.AwsContext;
import com.hss.domain.usecase.mapper.InvoiceSpredsheetMapper;
import jakarta.inject.Singleton;

@Singleton
public class ByteConverterActivity extends FluxItem<String, AwsContext, String> {

    @Override
    public String doExecute(String s, AwsContext awsContext) {
        var data = InvoiceSpredsheetMapper.buildObject(awsContext.getBytesFile());
        return "";
    }

    @Override
    public String processException(String s, AwsContext awsContext, Exception e) {
        return "";
    }
}
