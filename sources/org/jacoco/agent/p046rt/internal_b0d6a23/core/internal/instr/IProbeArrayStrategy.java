package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.IProbeArrayStrategy */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/IProbeArrayStrategy.class */
public interface IProbeArrayStrategy {
    int storeInstance(MethodVisitor methodVisitor, int i);

    void addMembers(ClassVisitor classVisitor, int i);
}
