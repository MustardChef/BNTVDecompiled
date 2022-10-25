package org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime;

import com.fasterxml.jackson.core.JsonPointer;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.Field;
import java.security.ProtectionDomain;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassReader;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassWriter;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.runtime.ModifiedSystemClassRuntime */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/runtime/ModifiedSystemClassRuntime.class */
public class ModifiedSystemClassRuntime extends AbstractRuntime {
    private static final String ACCESS_FIELD_TYPE = "Ljava/lang/Object;";
    private final Class<?> systemClass;
    private final String systemClassName;
    private final String accessFieldName;

    public ModifiedSystemClassRuntime(Class<?> systemClass, String accessFieldName) {
        this.systemClass = systemClass;
        this.systemClassName = systemClass.getName().replace('.', JsonPointer.SEPARATOR);
        this.accessFieldName = accessFieldName;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AbstractRuntime, org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IRuntime
    public void startup(RuntimeData data) throws Exception {
        super.startup(data);
        Field field = this.systemClass.getField(this.accessFieldName);
        field.set(null, data);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IRuntime
    public void shutdown() {
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IExecutionDataAccessorGenerator
    public int generateDataAccessor(long classid, String classname, int probecount, MethodVisitor mv) {
        mv.visitFieldInsn(178, this.systemClassName, this.accessFieldName, ACCESS_FIELD_TYPE);
        RuntimeData.generateAccessCall(classid, classname, probecount, mv);
        return 6;
    }

    public static IRuntime createFor(Instrumentation inst, String className) throws ClassNotFoundException {
        return createFor(inst, className, "$jacocoAccess");
    }

    public static IRuntime createFor(Instrumentation inst, final String className, final String accessFieldName) throws ClassNotFoundException {
        ClassFileTransformer transformer = new ClassFileTransformer() { // from class: org.jacoco.agent.rt.internal_b0d6a23.core.runtime.ModifiedSystemClassRuntime.1
            public byte[] transform(ClassLoader loader, String name, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] source) throws IllegalClassFormatException {
                if (name.equals(className)) {
                    return ModifiedSystemClassRuntime.instrument(source, accessFieldName);
                }
                return null;
            }
        };
        inst.addTransformer(transformer);
        Class<?> clazz = Class.forName(className.replace(JsonPointer.SEPARATOR, '.'));
        inst.removeTransformer(transformer);
        try {
            clazz.getField(accessFieldName);
            return new ModifiedSystemClassRuntime(clazz, accessFieldName);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(String.format("Class %s could not be instrumented.", className), e);
        }
    }

    public static byte[] instrument(byte[] source, final String accessFieldName) {
        ClassReader reader = new ClassReader(source);
        ClassWriter writer = new ClassWriter(reader, 0);
        reader.accept(new ClassVisitor(327680, writer) { // from class: org.jacoco.agent.rt.internal_b0d6a23.core.runtime.ModifiedSystemClassRuntime.2
            @Override // org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor
            public void visitEnd() {
                ModifiedSystemClassRuntime.createDataField(this.f10697cv, accessFieldName);
                super.visitEnd();
            }
        }, 8);
        return writer.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void createDataField(ClassVisitor visitor, String dataField) {
        visitor.visitField(4233, dataField, ACCESS_FIELD_TYPE, null, null);
    }
}
