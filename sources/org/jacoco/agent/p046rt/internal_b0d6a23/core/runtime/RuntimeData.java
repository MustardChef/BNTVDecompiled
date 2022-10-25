package org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.MethodVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.data.ExecutionData;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.data.ExecutionDataStore;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.data.IExecutionDataVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.data.ISessionInfoVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.data.SessionInfo;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.InstrSupport;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.runtime.RuntimeData */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/runtime/RuntimeData.class */
public class RuntimeData {
    protected final ExecutionDataStore store = new ExecutionDataStore();
    private String sessionId = "<none>";
    private long startTimeStamp = System.currentTimeMillis();

    public void setSessionId(String id) {
        this.sessionId = id;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public final void collect(IExecutionDataVisitor executionDataVisitor, ISessionInfoVisitor sessionInfoVisitor, boolean reset) {
        synchronized (this.store) {
            SessionInfo info = new SessionInfo(this.sessionId, this.startTimeStamp, System.currentTimeMillis());
            sessionInfoVisitor.visitSessionInfo(info);
            this.store.accept(executionDataVisitor);
            if (reset) {
                reset();
            }
        }
    }

    public final void reset() {
        synchronized (this.store) {
            this.store.reset();
            this.startTimeStamp = System.currentTimeMillis();
        }
    }

    public ExecutionData getExecutionData(Long id, String name, int probecount) {
        ExecutionData executionData;
        synchronized (this.store) {
            executionData = this.store.get(id, name, probecount);
        }
        return executionData;
    }

    public void getProbes(Object[] args) {
        Long classid = (Long) args[0];
        String name = (String) args[1];
        int probecount = ((Integer) args[2]).intValue();
        args[0] = getExecutionData(classid, name, probecount).getProbes();
    }

    public boolean equals(Object args) {
        if (args instanceof Object[]) {
            getProbes((Object[]) args);
        }
        return super.equals(args);
    }

    public static void generateArgumentArray(long classid, String classname, int probecount, MethodVisitor mv) {
        mv.visitInsn(6);
        mv.visitTypeInsn(189, "java/lang/Object");
        mv.visitInsn(89);
        mv.visitInsn(3);
        mv.visitLdcInsn(Long.valueOf(classid));
        mv.visitMethodInsn(184, "java/lang/Long", "valueOf", "(J)Ljava/lang/Long;", false);
        mv.visitInsn(83);
        mv.visitInsn(89);
        mv.visitInsn(4);
        mv.visitLdcInsn(classname);
        mv.visitInsn(83);
        mv.visitInsn(89);
        mv.visitInsn(5);
        InstrSupport.push(mv, probecount);
        mv.visitMethodInsn(184, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
        mv.visitInsn(83);
    }

    public static void generateAccessCall(long classid, String classname, int probecount, MethodVisitor mv) {
        generateArgumentArray(classid, classname, probecount, mv);
        mv.visitInsn(90);
        mv.visitMethodInsn(182, "java/lang/Object", "equals", "(Ljava/lang/Object;)Z", false);
        mv.visitInsn(87);
        mv.visitInsn(3);
        mv.visitInsn(50);
        mv.visitTypeInsn(192, InstrSupport.DATAFIELD_DESC);
    }
}
