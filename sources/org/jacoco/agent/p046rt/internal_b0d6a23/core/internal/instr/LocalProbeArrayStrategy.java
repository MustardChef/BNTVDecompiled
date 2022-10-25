package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.LocalProbeArrayStrategy */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/LocalProbeArrayStrategy.class */
class LocalProbeArrayStrategy implements IProbeArrayStrategy {
    private final String className;
    private final long classId;
    private final int probeCount;
    private final IExecutionDataAccessorGenerator accessorGenerator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalProbeArrayStrategy(String className, long classId, int probeCount, IExecutionDataAccessorGenerator accessorGenerator) {
        this.className = className;
        this.classId = classId;
        this.probeCount = probeCount;
        this.accessorGenerator = accessorGenerator;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.IProbeArrayStrategy
    public int storeInstance(MethodVisitor mv, int variable) {
        int maxStack = this.accessorGenerator.generateDataAccessor(this.classId, this.className, this.probeCount, mv);
        mv.visitVarInsn(58, variable);
        return maxStack;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.IProbeArrayStrategy
    public void addMembers(ClassVisitor delegate, int probeCount) {
    }
}
