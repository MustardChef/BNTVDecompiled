package org.jacoco.agent.p046rt.internal_b0d6a23.asm;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.AnnotationVisitor */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/AnnotationVisitor.class */
public abstract class AnnotationVisitor {
    protected final int api;

    /* renamed from: av */
    protected AnnotationVisitor f10693av;

    public AnnotationVisitor(int api) {
        this(api, null);
    }

    public AnnotationVisitor(int api, AnnotationVisitor av) {
        if (api != 262144 && api != 327680) {
            throw new IllegalArgumentException();
        }
        this.api = api;
        this.f10693av = av;
    }

    public void visit(String name, Object value) {
        if (this.f10693av != null) {
            this.f10693av.visit(name, value);
        }
    }

    public void visitEnum(String name, String desc, String value) {
        if (this.f10693av != null) {
            this.f10693av.visitEnum(name, desc, value);
        }
    }

    public AnnotationVisitor visitAnnotation(String name, String desc) {
        if (this.f10693av != null) {
            return this.f10693av.visitAnnotation(name, desc);
        }
        return null;
    }

    public AnnotationVisitor visitArray(String name) {
        if (this.f10693av != null) {
            return this.f10693av.visitArray(name);
        }
        return null;
    }

    public void visitEnd() {
        if (this.f10693av != null) {
            this.f10693av.visitEnd();
        }
    }
}
