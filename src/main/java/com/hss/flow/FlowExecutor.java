package com.hss.flow;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FlowExecutor<I, CTX, O> extends FlowInter{

    private List<FlowItem<?, CTX, ?>> flowItem;

    public O execute(Object input, CTX ctx) {

        for (FlowItem flowItem : flowItem) {
            try {
                var response = flowItem.execute(input, ctx);
                input = response;
            } catch (Exception e) {
                var response = flowItem.processException(input, ctx, e);
                input = response;
            }

        }
        return (O) input;
    }
}
