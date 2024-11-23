package com.hss.workflow.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@Serdeable
public class SqsModelInvoice {

    private List<InvoiceModel> invoiceModels;
    private byte[] bytes;
}
