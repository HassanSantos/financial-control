package com.hss.flow;

import java.util.List;

public class FlowTeste<CTX> {

    public FlowExecutor builder(List<FlowItem<?, CTX, ?>> flowItem) {
        return new FlowExecutor<>(flowItem);
    }
}
