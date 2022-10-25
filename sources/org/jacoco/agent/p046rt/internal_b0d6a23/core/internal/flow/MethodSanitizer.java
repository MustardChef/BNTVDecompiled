package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.commons.JSRInlinerAdapter;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.flow.MethodSanitizer */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/flow/MethodSanitizer.class */
public class MethodSanitizer extends JSRInlinerAdapter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodSanitizer(MethodVisitor mv, int access, String name, String desc, String signature, String[] exceptions) {
        super(327680, mv, access, name, desc, signature, exceptions);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.MethodNode, org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLocalVariable(String name, String desc, String signature, Label start, Label end, int index) {
        if (start.info != null && end.info != null) {
            super.visitLocalVariable(name, desc, signature, start, end, index);
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.MethodNode, org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
    public void visitLineNumber(int line, Label start) {
        if (start.info != null) {
            super.visitLineNumber(line, start);
        }
    }
}
