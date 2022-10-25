package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Handle;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.DuplicateFrameEliminator */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/DuplicateFrameEliminator.class */
class DuplicateFrameEliminator extends MethodVisitor {
    private boolean instruction;

    public DuplicateFrameEliminator(MethodVisitor mv) {
        super(327680, mv);
        this.instruction = true;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        if (this.instruction) {
            this.instruction = false;
            this.f10701mv.visitFrame(type, nLocal, local, nStack, stack);
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitInsn(int opcode) {
        this.instruction = true;
        this.f10701mv.visitInsn(opcode);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitIntInsn(int opcode, int operand) {
        this.instruction = true;
        this.f10701mv.visitIntInsn(opcode, operand);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitVarInsn(int opcode, int var) {
        this.instruction = true;
        this.f10701mv.visitVarInsn(opcode, var);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitTypeInsn(int opcode, String type) {
        this.instruction = true;
        this.f10701mv.visitTypeInsn(opcode, type);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitFieldInsn(int opcode, String owner, String name, String desc) {
        this.instruction = true;
        this.f10701mv.visitFieldInsn(opcode, owner, name, desc);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        this.instruction = true;
        this.f10701mv.visitMethodInsn(opcode, owner, name, desc, itf);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitInvokeDynamicInsn(String name, String desc, Handle bsm, Object... bsmArgs) {
        this.instruction = true;
        this.f10701mv.visitInvokeDynamicInsn(name, desc, bsm, bsmArgs);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitJumpInsn(int opcode, Label label) {
        this.instruction = true;
        this.f10701mv.visitJumpInsn(opcode, label);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLdcInsn(Object cst) {
        this.instruction = true;
        this.f10701mv.visitLdcInsn(cst);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitIincInsn(int var, int increment) {
        this.instruction = true;
        this.f10701mv.visitIincInsn(var, increment);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitTableSwitchInsn(int min, int max, Label dflt, Label... labels) {
        this.instruction = true;
        this.f10701mv.visitTableSwitchInsn(min, max, dflt, labels);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLookupSwitchInsn(Label dflt, int[] keys, Label[] labels) {
        this.instruction = true;
        this.f10701mv.visitLookupSwitchInsn(dflt, keys, labels);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitMultiANewArrayInsn(String desc, int dims) {
        this.instruction = true;
        this.f10701mv.visitMultiANewArrayInsn(desc, dims);
    }
}
