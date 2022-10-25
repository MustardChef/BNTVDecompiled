package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Opcodes;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.commons.AnalyzerAdapter;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.flow.FrameSnapshot */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/flow/FrameSnapshot.class */
class FrameSnapshot implements IFrame {
    private static final FrameSnapshot NOP = new FrameSnapshot(null, null);
    private final Object[] locals;
    private final Object[] stack;

    private FrameSnapshot(Object[] locals, Object[] stack) {
        this.locals = locals;
        this.stack = stack;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IFrame create(AnalyzerAdapter analyzer, int popCount) {
        if (analyzer == null || analyzer.locals == null) {
            return NOP;
        }
        Object[] locals = reduce(analyzer.locals, 0);
        Object[] stack = reduce(analyzer.stack, popCount);
        return new FrameSnapshot(locals, stack);
    }

    private static Object[] reduce(List<Object> source, int popCount) {
        List<Object> copy = new ArrayList<>(source);
        int size = source.size() - popCount;
        copy.subList(size, source.size()).clear();
        int i = size;
        while (true) {
            i--;
            if (i >= 0) {
                Object type = source.get(i);
                if (type == Opcodes.LONG || type == Opcodes.DOUBLE) {
                    copy.remove(i + 1);
                }
            } else {
                return copy.toArray();
            }
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.IFrame
    public void accept(MethodVisitor mv) {
        if (this.locals != null) {
            mv.visitFrame(-1, this.locals.length, this.locals, this.stack.length, this.stack);
        }
    }
}
