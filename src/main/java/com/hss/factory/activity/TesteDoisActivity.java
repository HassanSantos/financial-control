package com.hss.factory.activity;

import com.hss.flow.FlowItem;
import com.hss.flow.model.TesteContext;
import jakarta.inject.Singleton;

@Singleton
public class TesteDoisActivity extends FlowItem<String, TesteContext, String> {

    @Override
    public String doExecute(String is, TesteContext testeContext) {
        testeContext.setData("123456");
        return is;
    }

    @Override
    public String processException(String inputTeste, TesteContext testeContext, Exception e) {
        return "";
    }
}
