package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.FieldVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.ClassProbesVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.MethodProbesVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.ClassInstrumenter */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/ClassInstrumenter.class */
public class ClassInstrumenter extends ClassProbesVisitor {
    private final IProbeArrayStrategy probeArrayStrategy;
    private String className;

    public ClassInstrumenter(IProbeArrayStrategy probeArrayStrategy, ClassVisitor cv) {
        super(cv);
        this.probeArrayStrategy = probeArrayStrategy;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.className = name;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        InstrSupport.assertNotInstrumented(name, this.className);
        return super.visitField(access, name, desc, signature, value);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.ClassProbesVisitor, org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public MethodProbesVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        InstrSupport.assertNotInstrumented(name, this.className);
        MethodVisitor mv = this.f10697cv.visitMethod(access, name, desc, signature, exceptions);
        if (mv == null) {
            return null;
        }
        MethodVisitor frameEliminator = new DuplicateFrameEliminator(mv);
        ProbeInserter probeVariableInserter = new ProbeInserter(access, desc, frameEliminator, this.probeArrayStrategy);
        return new MethodInstrumenter(probeVariableInserter, probeVariableInserter);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.ClassProbesVisitor
    public void visitTotalProbeCount(int count) {
        this.probeArrayStrategy.addMembers(this.f10697cv, count);
    }
}
