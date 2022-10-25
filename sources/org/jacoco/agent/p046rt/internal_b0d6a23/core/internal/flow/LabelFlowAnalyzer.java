package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Handle;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.MethodNode;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.flow.LabelFlowAnalyzer */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/flow/LabelFlowAnalyzer.class */
public final class LabelFlowAnalyzer extends MethodVisitor {
    boolean successor;
    boolean first;
    Label lineStart;

    public static void markLabels(MethodNode method) {
        MethodVisitor lfa = new LabelFlowAnalyzer();
        int i = method.tryCatchBlocks.size();
        while (true) {
            i--;
            if (i >= 0) {
                method.tryCatchBlocks.get(i).accept(lfa);
            } else {
                method.instructions.accept(lfa);
                return;
            }
        }
    }

    public LabelFlowAnalyzer() {
        super(327680);
        this.successor = false;
        this.first = true;
        this.lineStart = null;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitTryCatchBlock(Label start, Label end, Label handler, String type) {
        LabelInfo.setTarget(start);
        LabelInfo.setTarget(handler);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitJumpInsn(int opcode, Label label) {
        LabelInfo.setTarget(label);
        if (opcode == 168) {
            throw new AssertionError("Subroutines not supported.");
        }
        this.successor = opcode != 167;
        this.first = false;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLabel(Label label) {
        if (this.first) {
            LabelInfo.setTarget(label);
        }
        if (this.successor) {
            LabelInfo.setSuccessor(label);
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLineNumber(int line, Label start) {
        this.lineStart = start;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        visitSwitchInsn(dflt, labels);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        visitSwitchInsn(dflt, labels);
    }

    private void visitSwitchInsn(Label dflt, Label[] labels) {
        LabelInfo.resetDone(dflt);
        LabelInfo.resetDone(labels);
        setTargetIfNotDone(dflt);
        for (Label l : labels) {
            setTargetIfNotDone(l);
        }
        this.successor = false;
        this.first = false;
    }

    private static void setTargetIfNotDone(Label label) {
        if (!LabelInfo.isDone(label)) {
            LabelInfo.setTarget(label);
            LabelInfo.setDone(label);
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitInsn(int opcode) {
        switch (opcode) {
            case 169:
                throw new AssertionError("Subroutines not supported.");
            case 170:
            case 171:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case 190:
            default:
                this.successor = true;
                break;
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 177:
            case 191:
                this.successor = false;
                break;
        }
        this.first = false;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitIntInsn(int opcode, int operand) {
        this.successor = true;
        this.first = false;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitVarInsn(int opcode, int var) {
        this.successor = true;
        this.first = false;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitTypeInsn(int opcode, String type) {
        this.successor = true;
        this.first = false;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        this.successor = true;
        this.first = false;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        this.successor = true;
        this.first = false;
        markMethodInvocationLine();
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        this.successor = true;
        this.first = false;
        markMethodInvocationLine();
    }

    private void markMethodInvocationLine() {
        if (this.lineStart != null) {
            LabelInfo.setMethodInvocationLine(this.lineStart);
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLdcInsn(Object cst) {
        this.successor = true;
        this.first = false;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitIincInsn(int var, int increment) {
        this.successor = true;
        this.first = false;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String desc, int dims) {
        this.successor = true;
        this.first = false;
    }
}
