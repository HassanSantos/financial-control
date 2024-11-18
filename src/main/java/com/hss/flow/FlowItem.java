package com.hss.flow;

public abstract class FlowItem <I, C, O> {

    public abstract O doExecute(I i, C c) throws Exception;

    O execute(I i, C c) throws Exception {
         return doExecute(i, c);
    }

    public abstract O processException(I i, C c, Exception e);
}
