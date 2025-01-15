package com.hss.domain.usecase.activity;

import com.hss.FluxItem;
import com.hss.adapter.outbound.sqs.model.ModelSendSqs;
import com.hss.domain.usecase.activity.exception.MessagerByteException;
import com.hss.domain.usecase.context.AwsContext;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Singleton;

@Singleton
public class MessagerByteActivity extends FluxItem<String, AwsContext, String> {

    @Override
    public String doExecute(String s, AwsContext awsContext) throws Exception {
        awsContext.setBytesFile(getBytesFile(s));
        return "";
    }


    private byte[] getBytesFile(String messages) throws Exception {
        return ObjectMapper.getDefault().readValue(messages, ModelSendSqs.class).getBytesFile();
    }

    @Override
    public String processException(String s, AwsContext awsContext, Exception e) {
        throw new MessagerByteException(e.getMessage(), "error converting message");
    }
}
