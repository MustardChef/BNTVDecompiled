package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Opcodes;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Type;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.ProbeInserter */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/ProbeInserter.class */
class ProbeInserter extends MethodVisitor implements IProbeInserter {
    private final IProbeArrayStrategy arrayStrategy;
    private final int variable;
    private int accessorStackSize;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProbeInserter(int access, String desc, MethodVisitor mv, IProbeArrayStrategy arrayStrategy) {
        super(327680, mv);
        this.arrayStrategy = arrayStrategy;
        int pos = (8 & access) == 0 ? 1 : 0;
        Type[] arr$ = Type.getArgumentTypes(desc);
        for (Type t : arr$) {
            pos += t.getSize();
        }
        this.variable = pos;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.IProbeInserter
    public void insertProbe(int id) {
        this.f10701mv.visitVarInsn(25, this.variable);
        InstrSupport.push(this.f10701mv, id);
        this.f10701mv.visitInsn(4);
        this.f10701mv.visitInsn(84);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitCode() {
        this.accessorStackSize = this.arrayStrategy.storeInstance(this.f10701mv, this.variable);
        this.f10701mv.visitCode();
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public final void visitVarInsn(int opcode, int var) {
        this.f10701mv.visitVarInsn(opcode, map(var));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public final void visitIincInsn(int var, int increment) {
        this.f10701mv.visitIincInsn(map(var), increment);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public final void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        this.f10701mv.visitLocalVariable(name, desc, signature, start, end, map(index));
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitMaxs(int maxStack, int maxLocals) {
        int increasedStack = Math.max(maxStack + 3, this.accessorStackSize);
        this.f10701mv.visitMaxs(increasedStack, maxLocals + 1);
    }

    private int map(int var) {
        if (var < this.variable) {
            return var;
        }
        return var + 1;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public final void visitFrame(int type, int nLocal, Object[] local, int nStack, Object[] stack) {
        if (type != -1) {
            throw new IllegalArgumentException("ClassReader.accept() should be called with EXPAND_FRAMES flag");
        }
        Object[] newLocal = new Object[Math.max(nLocal, this.variable) + 1];
        int idx = 0;
        int newIdx = 0;
        int pos = 0;
        while (true) {
            if (idx < nLocal || pos <= this.variable) {
                if (pos == this.variable) {
                    int i = newIdx;
                    newIdx++;
                    newLocal[i] = InstrSupport.DATAFIELD_DESC;
                    pos++;
                } else if (idx < nLocal) {
                    int i2 = idx;
                    idx++;
                    Object t = local[i2];
                    int i3 = newIdx;
                    newIdx++;
                    newLocal[i3] = t;
                    pos++;
                    if (t == Opcodes.LONG || t == Opcodes.DOUBLE) {
                        pos++;
                    }
                } else {
                    int i4 = newIdx;
                    newIdx++;
                    newLocal[i4] = Opcodes.TOP;
                    pos++;
                }
            } else {
                this.f10701mv.visitFrame(type, newIdx, newLocal, nStack, stack);
                return;
            }
        }
    }
}
