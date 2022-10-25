package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.instr.InstrSupport */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/instr/InstrSupport.class */
public final class InstrSupport {
    public static final String DATAFIELD_NAME = "$jacocoData";
    public static final int DATAFIELD_ACC = 4250;
    public static final int DATAFIELD_INTF_ACC = 4121;
    public static final String DATAFIELD_DESC = "[Z";
    public static final String INITMETHOD_NAME = "$jacocoInit";
    public static final String INITMETHOD_DESC = "()[Z";
    public static final int INITMETHOD_ACC = 4106;

    private InstrSupport() {
    }

    public static void assertNotInstrumented(String member, String owner) throws IllegalStateException {
        if (member.equals(DATAFIELD_NAME) || member.equals(INITMETHOD_NAME)) {
            throw new IllegalStateException(String.format("Class %s is already instrumented.", owner));
        }
    }

    public static void push(MethodVisitor mv, int value) {
        if (value >= -1 && value <= 5) {
            mv.visitInsn(3 + value);
        } else if (value >= -128 && value <= 127) {
            mv.visitIntInsn(16, value);
        } else if (value >= -32768 && value <= 32767) {
            mv.visitIntInsn(17, value);
        } else {
            mv.visitLdcInsn(Integer.valueOf(value));
        }
    }
}
