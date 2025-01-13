package com.hss.domain.usecase.activity;

import com.hss.FluxItem;
import com.hss.adapter.outbound.sqs.model.ModelSendSqs;
import com.hss.domain.usecase.context.AwsContext;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Singleton;

import java.io.IOException;

@Singleton
public class MessagerByteActivity extends FluxItem<String, AwsContext, String> {

    @Override
    public String doExecute(String s, AwsContext awsContext) throws Exception {
        awsContext.setBytesFile(getBytesFile(s));
        return "";
    }


    private byte[] getBytesFile(String messages) throws IOException {
        return ObjectMapper.getDefault().readValue(messages, ModelSendSqs.class).getBytesFile();
    }

    @Override
    public String processException(String s, AwsContext awsContext, Exception e) {
        return "";
    }
}
