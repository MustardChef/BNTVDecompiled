package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.flow.ClassProbesVisitor */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/flow/ClassProbesVisitor.class */
public abstract class ClassProbesVisitor extends ClassVisitor {
    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public abstract MethodProbesVisitor visitMethod(int i, String str, String str2, String str3, String[] strArr);

    public abstract void visitTotalProbeCount(int i);

    public ClassProbesVisitor() {
        this(null);
    }

    public ClassProbesVisitor(ClassVisitor cv) {
        super(327680, cv);
    }
}
