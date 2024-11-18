package com.hss.flow.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TesteContext {
    private String fileName;
    private String data;
    private String testando;
    private byte[] bytes;
    }
