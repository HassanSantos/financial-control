package com.hss.entrypoint.handle;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.hss.entrypoint.s3.S3UploadService;
import com.hss.workflow.model.SqsModelInvoice;
import io.micronaut.context.annotation.Factory;
import io.micronaut.serde.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Factory
public class LambdaHandlerSqs implements RequestHandler<SQSEvent, String> {

    @Override
    public String handleRequest(SQSEvent sqsEvent, Context context) {

        log.info("verificando aqui se entrou");
        var fasdf =ReceiveMessageRequest.builder()
                .maxNumberOfMessages(10)// Lê até 10 mensagens de uma vez
                .waitTimeSeconds(20); // Long polling por até 20 segundos para mensagens

        for (SQSEvent.SQSMessage message : sqsEvent.getRecords()) {
            // Imprime o conteúdo da mensagem recebida
            System.out.println("Mensagem recebidateste: " + message.getBody());

            try {

                System.out.println("enviado s3: ");

                SqsModelInvoice testes =  ObjectMapper.getDefault().readValue(message.getBody(), SqsModelInvoice.class);
                S3UploadService.sexndFile("testando.csv", testes.getBytes(), "expense-spreadsheet" );
                System.out.println("enviado s3: ");


            } catch (IOException e) {
                log.info("verificando aqui se deu erro");

                throw new RuntimeException(e);
            }

            // Aqui você pode implementar o processamento da mensagem
            // Se quiser deletar a mensagem após o processamento
        }
        return "Processamento concluído!";    }
}
