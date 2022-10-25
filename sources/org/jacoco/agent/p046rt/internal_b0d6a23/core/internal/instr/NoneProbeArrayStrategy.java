package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.NoneProbeArrayStrategy */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/NoneProbeArrayStrategy.class */
class NoneProbeArrayStrategy implements IProbeArrayStrategy {
    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.IProbeArrayStrategy
    public int storeInstance(MethodVisitor mv, int variable) {
        throw new UnsupportedOperationException();
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.IProbeArrayStrategy
    public void addMembers(ClassVisitor delegate, int probeCount) {
    }
}
