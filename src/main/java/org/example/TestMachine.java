package org.example;

import java.util.BitSet;

public class TestMachine extends Machine{
    public TestMachine(BitSet inputMask, BitSet outputMask) {
        super(inputMask, outputMask);
    }

    @Override
    public BitSet tick() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this.getOutputs();
    }
}
