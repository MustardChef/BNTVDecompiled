package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.FieldProbeArrayStrategy */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/FieldProbeArrayStrategy.class */
class FieldProbeArrayStrategy implements IProbeArrayStrategy {
    private static final Object[] FRAME_STACK_ARRZ = {InstrSupport.DATAFIELD_DESC};
    private static final Object[] FRAME_LOCALS_EMPTY = new Object[0];
    private final String className;
    private final long classId;
    private final boolean withFrames;
    private final int fieldAccess;
    private final IExecutionDataAccessorGenerator accessorGenerator;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldProbeArrayStrategy(String className, long classId, boolean withFrames, int fieldAccess, IExecutionDataAccessorGenerator accessorGenerator) {
        this.className = className;
        this.classId = classId;
        this.withFrames = withFrames;
        this.fieldAccess = fieldAccess;
        this.accessorGenerator = accessorGenerator;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.IProbeArrayStrategy
    public int storeInstance(MethodVisitor mv, int variable) {
        mv.visitMethodInsn(184, this.className, InstrSupport.INITMETHOD_NAME, InstrSupport.INITMETHOD_DESC, false);
        mv.visitVarInsn(58, variable);
        return 1;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.IProbeArrayStrategy
    public void addMembers(ClassVisitor cv, int probeCount) {
        createDataField(cv);
        createInitMethod(cv, probeCount);
    }

    private void createDataField(ClassVisitor cv) {
        cv.visitField(this.fieldAccess, InstrSupport.DATAFIELD_NAME, InstrSupport.DATAFIELD_DESC, null, null);
    }

    private void createInitMethod(ClassVisitor cv, int probeCount) {
        MethodVisitor mv = cv.visitMethod(InstrSupport.INITMETHOD_ACC, InstrSupport.INITMETHOD_NAME, InstrSupport.INITMETHOD_DESC, null, null);
        mv.visitCode();
        mv.visitFieldInsn(178, this.className, InstrSupport.DATAFIELD_NAME, InstrSupport.DATAFIELD_DESC);
        mv.visitInsn(89);
        Label alreadyInitialized = new Label();
        mv.visitJumpInsn(199, alreadyInitialized);
        mv.visitInsn(87);
        int size = genInitializeDataField(mv, probeCount);
        if (this.withFrames) {
            mv.visitFrame(-1, 0, FRAME_LOCALS_EMPTY, 1, FRAME_STACK_ARRZ);
        }
        mv.visitLabel(alreadyInitialized);
        mv.visitInsn(176);
        mv.visitMaxs(Math.max(size, 2), 0);
        mv.visitEnd();
    }

    private int genInitializeDataField(MethodVisitor mv, int probeCount) {
        int size = this.accessorGenerator.generateDataAccessor(this.classId, this.className, probeCount, mv);
        mv.visitInsn(89);
        mv.visitFieldInsn(179, this.className, InstrSupport.DATAFIELD_NAME, InstrSupport.DATAFIELD_DESC);
        return Math.max(size, 2);
    }
}
