package com.hss.factory;

import com.hss.factory.activity.TesteActivity;
import com.hss.factory.activity.TesteDoisActivity;
import com.hss.flow.FlowBuilder;
import com.hss.flow.FlowExecutorImpl;
import com.hss.flow.model.TesteContext;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import jakarta.inject.Named;

import java.io.InputStream;

@Factory
public record FlowTesteFactory(TesteActivity testeActivity, TesteDoisActivity testeDoisActivity) {

    @Bean
    @Named
    public FlowExecutorImpl<InputStream, TesteContext, String> testes() {
        return new FlowBuilder<TesteContext>()
                .step(testeActivity)
                .step(testeDoisActivity)
                .builder();
    }
}
