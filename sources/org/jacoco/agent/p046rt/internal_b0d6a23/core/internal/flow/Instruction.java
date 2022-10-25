package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.flow.Instruction */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/flow/Instruction.class */
public class Instruction {
    private final int line;
    private int branches = 0;
    private int coveredBranches = 0;
    private Instruction predecessor;

    public Instruction(int line) {
        this.line = line;
    }

    public void addBranch() {
        this.branches++;
    }

    public void setPredecessor(Instruction predecessor) {
        this.predecessor = predecessor;
        predecessor.addBranch();
    }

    public void setCovered() {
        Instruction instruction = this;
        while (true) {
            Instruction i = instruction;
            if (i == null) {
                return;
            }
            int i2 = i.coveredBranches;
            i.coveredBranches = i2 + 1;
            if (i2 == 0) {
                instruction = i.predecessor;
            } else {
                return;
            }
        }
    }

    public int getLine() {
        return this.line;
    }

    public int getBranches() {
        return this.branches;
    }

    public int getCoveredBranches() {
        return this.coveredBranches;
    }
}
