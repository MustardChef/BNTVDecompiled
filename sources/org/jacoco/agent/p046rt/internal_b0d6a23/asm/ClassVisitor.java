package org.jacoco.agent.p046rt.internal_b0d6a23.asm;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.asm.ClassVisitor */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/asm/ClassVisitor.class */
public abstract class ClassVisitor {
    protected final int api;

    /* renamed from: cv */
    protected ClassVisitor f10697cv;

    public ClassVisitor(int api) {
        this(api, null);
    }

    public ClassVisitor(int api, ClassVisitor cv) {
        if (api != 262144 && api != 327680) {
            throw new IllegalArgumentException();
        }
        this.api = api;
        this.f10697cv = cv;
    }

    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        if (this.f10697cv != null) {
            this.f10697cv.visit(version, access, name, signature, superName, interfaces);
        }
    }

    public void visitSource(String source, String debug) {
        if (this.f10697cv != null) {
            this.f10697cv.visitSource(source, debug);
        }
    }

    public void visitOuterClass(String owner, String name, String desc) {
        if (this.f10697cv != null) {
            this.f10697cv.visitOuterClass(owner, name, desc);
        }
    }

    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        if (this.f10697cv != null) {
            return this.f10697cv.visitAnnotation(desc, visible);
        }
        return null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String desc, boolean visible) {
        if (this.api < 327680) {
            throw new RuntimeException();
        }
        if (this.f10697cv != null) {
            return this.f10697cv.visitTypeAnnotation(typeRef, typePath, desc, visible);
        }
        return null;
    }

    public void visitAttribute(Attribute attr) {
        if (this.f10697cv != null) {
            this.f10697cv.visitAttribute(attr);
        }
    }

    public void visitInnerClass(String name, String outerName, String innerName, int access) {
        if (this.f10697cv != null) {
            this.f10697cv.visitInnerClass(name, outerName, innerName, access);
        }
    }

    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if (this.f10697cv != null) {
            return this.f10697cv.visitField(access, name, desc, signature, value);
        }
        return null;
    }

    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (this.f10697cv != null) {
            return this.f10697cv.visitMethod(access, name, desc, signature, exceptions);
        }
        return null;
    }

    public void visitEnd() {
        if (this.f10697cv != null) {
            this.f10697cv.visitEnd();
        }
    }
}
