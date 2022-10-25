package org.jacoco.agent.p046rt.internal_b0d6a23.asm;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.FieldVisitor */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/FieldVisitor.class */
public abstract class FieldVisitor {
    protected final int api;

    /* renamed from: fv */
    protected FieldVisitor f10699fv;

    public FieldVisitor(int api) {
        this(api, null);
    }

    public FieldVisitor(int api, FieldVisitor fv) {
        if (api != 262144 && api != 327680) {
            throw new IllegalArgumentException();
        }
        this.api = api;
        this.f10699fv = fv;
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        if (this.f10699fv != null) {
            return this.f10699fv.visitAnnotation(desc, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        if (this.api < 327680) {
            throw new RuntimeException();
        }
        if (this.f10699fv != null) {
            return this.f10699fv.visitTypeAnnotation(typeRef, typePath, desc, visible);
        }
        return null;
    }

    public void visitAttribute(Attribute attr) {
        if (this.f10699fv != null) {
            this.f10699fv.visitAttribute(attr);
        }
    }

    public void visitEnd() {
        if (this.f10699fv != null) {
            this.f10699fv.visitEnd();
        }
    }
}
