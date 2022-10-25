package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.ClassProbesVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.MethodProbesVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.ProbeCounter */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/ProbeCounter.class */
class ProbeCounter extends ClassProbesVisitor {
    private int count = 0;
    private boolean methods = false;

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.ClassProbesVisitor, org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public MethodProbesVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (!"<clinit>".equals(name)) {
            this.methods = true;
            return null;
        }
        return null;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.ClassProbesVisitor
    public void visitTotalProbeCount(int count) {
        this.count = count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCount() {
        return this.count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasMethods() {
        return this.methods;
    }
}
