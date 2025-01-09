package com.hss.adapter.outbound.sqs.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@Introspected
@Serdeable
public class ModelSendSqs implements Serializable {

    private byte[] bytesFile;
}
