package org.example;

import java.util.BitSet;

public abstract class StateMachine extends Machine {

    private State[] states;
    private State currentState;

    private int startState;

    public StateMachine(BitSet inputMask, BitSet outputMask, State[] states, int startState) {
        super(inputMask, outputMask);
        this.states = states;
        this.startState = startState;
    }

    public void start() {
        if (super.isRunning()) {
            System.err.println("Machine already running!");
            return;
        }
        if (startState >= states.length) {
            System.err.printf("Index %d is bigger than maximum %d\n", startState, states.length-1);
            return;
        }
        this.currentState = states[startState];
        super.setRunning(true);
    }

    public BitSet tick() {
        return currentState.run(this);
    }
}
