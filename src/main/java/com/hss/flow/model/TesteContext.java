package com.hss.flow.model;

import com.hss.model.FaturaModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TesteContext {
    private String fileName;
    private String data;
    private String testando;
    private byte[] bytes;
    private List<FaturaModel> faturaModels;
}
