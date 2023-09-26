package org.example;

import java.util.BitSet;

public abstract class Machine {
    private BitSet inputMask;
    private BitSet outputMask;
    private BitSet inputs;
    private BitSet outputs;

    private boolean running = false;

    public Machine (BitSet inputMask, BitSet outputMask) {
        this.inputMask = inputMask;
        this.outputMask = outputMask;
    }

    public void start() {
        if (running) {
            System.err.println("Machine already running!");
            return;
        }
        running = true;
    }

    /**
     * Gets run once every tick
     * @return new and modified output data
     */
    public abstract BitSet tick();

    public void update(BitSet inputData, BitSet outputData) {
        this.inputs = inputData;
        this.outputs = outputData;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }

    public BitSet getInputMask() {
        return inputMask;
    }

    public BitSet getOutputMask() {
        return outputMask;
    }
}
