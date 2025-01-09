package com.hss.domain.usecase;

import com.hss.FluxBuilder;
import com.hss.FluxExecutorImpl;
import com.hss.domain.usecase.activity.SaveS3Activity;
import com.hss.domain.usecase.activity.SendToDynamondActivity;
import com.hss.domain.usecase.context.AwsContext;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

@Factory
public record ManipuleFileUseCase(SaveS3Activity saveS3Activity,
                                  SendToDynamondActivity sendToDynamondActivity) {

    @Bean
    public FluxExecutorImpl<String, AwsContext, String> fifoWorkflow() {
        return new FluxBuilder<AwsContext>()
                .step(saveS3Activity)
                .step(sendToDynamondActivity)
                .builder();
    }
}
