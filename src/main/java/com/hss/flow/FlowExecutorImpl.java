package com.hss.flow;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class FlowExecutorImpl<I, CTX, O> extends FlowExecutor {

    private List<FlowItem<?, CTX, ?>> flowItem;

    public O execute(Object input, CTX ctx) {

        for (FlowItem flowItem : flowItem) {
            try {
                var response = flowItem.execute(input, ctx);
                input = response;
            } catch (Exception e) {
                input = flowItem.processException(input, ctx, e);
            }

        }
        return (O) input;
    }
}
