package com.hss.flow;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FlowBuilder {

    private Object ctx;
    private Object input;
    private List<FlowItem> flowItem = new ArrayList<>();

    public FlowBuilder step(FlowItem item) {
        flowItem.add(item);
        return this;
    }

    public FlowBuilder builder() {

        return this;
    }

    public Object execute(Object input, Object ctx) {

        for (FlowItem flowItem : flowItem) {
            try {
                var response = flowItem.execute(input, ctx);
                input = response;
            } catch (Exception e) {
                var response = flowItem.processException(input, ctx, e);
                input = response;
            }

        }
        return input;
    }
}
