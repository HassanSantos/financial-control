package config.flow;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FlowBuilder<CTX> {

    private List<FlowItem<?, CTX, ?>> flowItem = new ArrayList<>();

    public FlowBuilder<CTX> step(FlowItem<?, CTX, ?> item) {
        flowItem.add(item);
        return this;
    }

    public <T extends FlowExecutor> T builder() {
        return (T) new FlowExecutorImpl<>(flowItem);
    }

}
