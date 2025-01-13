package com.hss.domain.usecase;

import com.hss.FluxBuilder;
import com.hss.FluxExecutorImpl;
import com.hss.domain.usecase.activity.MessagerByteActivity;
import com.hss.domain.usecase.activity.SaveFileActivity;
import com.hss.domain.usecase.activity.ByteConverterActivity;
import com.hss.domain.usecase.context.AwsContext;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;

@Factory
public record ManipuleFileUseCase(MessagerByteActivity messagerByteActivity,
                                  SaveFileActivity saveFileActivity,
                                  ByteConverterActivity byteConverterActivity) {

    @Bean
    public FluxExecutorImpl<String, AwsContext, String> fifoWorkflow() {
        return new FluxBuilder<AwsContext>()
                .step(messagerByteActivity)
                .step(byteConverterActivity)
                .step(saveFileActivity)
                .builder();
    }
}
