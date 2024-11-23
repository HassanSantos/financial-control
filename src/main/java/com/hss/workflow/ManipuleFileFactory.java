package com.hss.workflow;

import com.hss.workflow.model.InvoiceModel;
import config.flow.FlowBuilder;
import config.flow.FlowExecutorImpl;

public record ManipuleFileFactory() {


    public FlowExecutorImpl<InvoiceModel, Void, String> saveDataFile(){
    return new FlowBuilder<Void>()
            .builder();
    }
}
