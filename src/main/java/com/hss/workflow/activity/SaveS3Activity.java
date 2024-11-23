package com.hss.workflow.activity;

import com.hss.workflow.model.SqsModelInvoice;
import config.flow.FlowItem;
import jakarta.inject.Singleton;

@Singleton
public class SaveS3Activity extends FlowItem<SqsModelInvoice, Void, String> {

    @Override
    public String doExecute(SqsModelInvoice sqsModelInvoice, Void unused) throws Exception {
        return "";
    }

    @Override
    public String processException(SqsModelInvoice sqsModelInvoice, Void unused, Exception e) {
        return "";
    }
}
