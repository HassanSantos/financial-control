package com.hss.factory.activity;

import com.hss.flow.FlowItem;
import com.hss.flow.model.TesteContext;
import jakarta.inject.Singleton;

import java.io.InputStream;

@Singleton
public class TesteActivity extends FlowItem<InputStream, TesteContext, String> {

    @Override
    public String doExecute(InputStream is, TesteContext testeContext) {
        throw  new RuntimeException("");
    }

    @Override
    public String processException(InputStream inputTeste, TesteContext testeContext, Exception e) {
        return "";
    }
}
