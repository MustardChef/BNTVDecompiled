package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.commons.AnalyzerAdapter;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.flow.ClassProbesAdapter */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/flow/ClassProbesAdapter.class */
public class ClassProbesAdapter extends ClassVisitor implements IProbeIdGenerator {
    private static final MethodProbesVisitor EMPTY_METHOD_PROBES_VISITOR = new MethodProbesVisitor() { // from class: org.jacoco.agent.rt.internal_b0d6a23.core.internal.flow.ClassProbesAdapter.1
    };

    /* renamed from: cv */
    private final ClassProbesVisitor f10708cv;
    private final boolean trackFrames;
    private int counter;
    private String name;

    public ClassProbesAdapter(ClassProbesVisitor cv, boolean trackFrames) {
        super(327680, cv);
        this.counter = 0;
        this.f10708cv = cv;
        this.trackFrames = trackFrames;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        this.name = name;
        super.visit(version, access, name, signature, superName, interfaces);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public final MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodProbesVisitor methodProbes;
        MethodProbesVisitor mv = this.f10708cv.visitMethod(access, name, desc, signature, exceptions);
        if (mv == null) {
            methodProbes = EMPTY_METHOD_PROBES_VISITOR;
        } else {
            methodProbes = mv;
        }
        final MethodProbesVisitor methodProbesVisitor = methodProbes;
        return new MethodSanitizer(null, access, name, desc, signature, exceptions) { // from class: org.jacoco.agent.rt.internal_b0d6a23.core.internal.flow.ClassProbesAdapter.2
            @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.commons.JSRInlinerAdapter, org.jacoco.agent.p046rt.internal_b0d6a23.asm.tree.MethodNode, org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor
            public void visitEnd() {
                super.visitEnd();
                LabelFlowAnalyzer.markLabels(this);
                MethodProbesAdapter probesAdapter = new MethodProbesAdapter(methodProbesVisitor, ClassProbesAdapter.this);
                if (ClassProbesAdapter.this.trackFrames) {
                    AnalyzerAdapter analyzer = new AnalyzerAdapter(ClassProbesAdapter.this.name, this.access, this.name, this.desc, probesAdapter);
                    probesAdapter.setAnalyzer(analyzer);
                    accept(analyzer);
                    return;
                }
                accept(probesAdapter);
            }
        };
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
    public void visitEnd() {
        this.f10708cv.visitTotalProbeCount(this.counter);
        super.visitEnd();
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.IProbeIdGenerator
    public int nextId() {
        int i = this.counter;
        this.counter = i + 1;
        return i;
    }
}
