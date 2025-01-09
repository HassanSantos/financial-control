package com.hss.workflow;

import com.hss.FluxBuilder;
import com.hss.FluxExecutorImpl;
import com.hss.workflow.activity.SaveS3Activity;
import com.hss.workflow.activity.SendToDynamondActivity;
import com.hss.workflow.context.AwsContext;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

@Factory
public record ManipuleFileFactory(SaveS3Activity saveS3Activity,
                                  SendToDynamondActivity sendToDynamondActivity) {

    @Bean
    public FluxExecutorImpl<String, AwsContext, String> fifoWorkflow() {
        return new FluxBuilder<AwsContext>()
                .step(saveS3Activity)
                .step(sendToDynamondActivity)
                .builder();
    }
}
