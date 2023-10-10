package org.example;

import java.util.BitSet;

public class Test {
    public static void main(String[] args) {
        Machine m = new TestMachine(new BitSet(0b001100), new BitSet(0b110000));

        System.out.println("Running pipe");
        AutomationPipeline pipe = new AutomationPipeline(new Machine[] {m});
        pipe.execute(5);
    }
}
