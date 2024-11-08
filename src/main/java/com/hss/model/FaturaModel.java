package com.hss.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FaturaModel {

    private String data;
    private String lancamento;
    private String categoria;
    private String tipo;
    private String valor;

}
