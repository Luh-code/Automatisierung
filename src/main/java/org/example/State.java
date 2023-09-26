package org.example;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class State {
    private Map<String, State> states;
    private Function<StateMachine, BitSet> func;

    public BitSet run(StateMachine sm) {
        return func.apply(sm);
    }

    public State changeState(String action) {
        if (!states.containsKey(action)) {
            System.err.printf("Unknown action '%s', in %s\n", action, Arrays.toString(states.keySet().toArray()));
            return this;
        }

        State s;
        if ((s = states.get(action)) == null) {
            System.err.printf("State '%s' is null!", action);
            return this;
        }

        return states.get(action);
    }
}
