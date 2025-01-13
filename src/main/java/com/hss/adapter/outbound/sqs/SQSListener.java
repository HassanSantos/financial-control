package com.hss.adapter.outbound.sqs;

import com.hss.FluxExecutorImpl;
import com.hss.config.envirioments.EnviriomentsModel;
import com.hss.domain.usecase.context.AwsContext;
import io.micronaut.scheduling.annotation.Scheduled;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Singleton;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

@Singleton
public record SQSListener(EnviriomentsModel enviriomentsModel, SqsClient sqsClient,
                          FluxExecutorImpl<String, AwsContext, String> fluxExecutor,
                          ObjectMapper objectMapper) {

    @Scheduled(fixedDelay = "5s", initialDelay = "5s")
    public void getMessager() {
        sqsClient.receiveMessage(getReceiveMessageRequest())
                .messages()
                .stream().filter(i -> i.body() != null)
                .toList()
                .forEach(i -> extracted(i.body()));
    }

    private ReceiveMessageRequest getReceiveMessageRequest() {
        return ReceiveMessageRequest.builder().queueUrl(enviriomentsModel.getInvoiceSpreadsheet()).build();
    }

    private void extracted(String messages) {

        try {
            fluxExecutor.execute(messages, AwsContext.builder().build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}