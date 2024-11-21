package com.hss.model;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@Serdeable

public class FaturaModel implements Serializable {
    private String data;
    private String lancamento;
    private String categoria;
    private String tipo;
    private String valor;

}
