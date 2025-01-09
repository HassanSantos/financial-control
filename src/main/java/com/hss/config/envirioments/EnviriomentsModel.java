package com.hss.config.envirioments;

import io.micronaut.context.annotation.Value;
import lombok.Data;

@Data
public class EnviriomentsModel {

    @Value(value ="${invoice-spreadsheet}")
    String invoiceSpreadsheet;
}
