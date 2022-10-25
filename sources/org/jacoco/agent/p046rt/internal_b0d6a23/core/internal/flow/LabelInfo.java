package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow;

import org.jacoco.agent.p046rt.internal_b0d6a23.asm.Label;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.flow.LabelInfo */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/flow/LabelInfo.class */
public final class LabelInfo {
    public static final int NO_PROBE = -1;
    private boolean target = false;
    private boolean multiTarget = false;
    private boolean successor = false;
    private boolean methodInvocationLine = false;
    private boolean done = false;
    private int probeid = -1;
    private Label intermediate = null;
    private Instruction instruction = null;

    private LabelInfo() {
    }

    public static void setTarget(Label label) {
        LabelInfo info = create(label);
        if (info.target || info.successor) {
            info.multiTarget = true;
        } else {
            info.target = true;
        }
    }

    public static void setSuccessor(Label label) {
        LabelInfo info = create(label);
        info.successor = true;
        if (info.target) {
            info.multiTarget = true;
        }
    }

    public static boolean isMultiTarget(Label label) {
        LabelInfo info = get(label);
        if (info == null) {
            return false;
        }
        return info.multiTarget;
    }

    public static boolean isSuccessor(Label label) {
        LabelInfo info = get(label);
        if (info == null) {
            return false;
        }
        return info.successor;
    }

    public static void setMethodInvocationLine(Label label) {
        create(label).methodInvocationLine = true;
    }

    public static boolean isMethodInvocationLine(Label label) {
        LabelInfo info = get(label);
        if (info == null) {
            return false;
        }
        return info.methodInvocationLine;
    }

    public static boolean needsProbe(Label label) {
        LabelInfo info = get(label);
        return info != null && info.successor && (info.multiTarget || info.methodInvocationLine);
    }

    public static void setDone(Label label) {
        create(label).done = true;
    }

    public static void resetDone(Label label) {
        LabelInfo info = get(label);
        if (info != null) {
            info.done = false;
        }
    }

    public static void resetDone(Label[] labels) {
        for (Label label : labels) {
            resetDone(label);
        }
    }

    public static boolean isDone(Label label) {
        LabelInfo info = get(label);
        if (info == null) {
            return false;
        }
        return info.done;
    }

    public static void setProbeId(Label label, int id) {
        create(label).probeid = id;
    }

    public static int getProbeId(Label label) {
        LabelInfo info = get(label);
        if (info == null) {
            return -1;
        }
        return info.probeid;
    }

    public static void setIntermediateLabel(Label label, Label intermediate) {
        create(label).intermediate = intermediate;
    }

    public static Label getIntermediateLabel(Label label) {
        LabelInfo info = get(label);
        if (info == null) {
            return null;
        }
        return info.intermediate;
    }

    public static void setInstruction(Label label, Instruction instruction) {
        create(label).instruction = instruction;
    }

    public static Instruction getInstruction(Label label) {
        LabelInfo info = get(label);
        if (info == null) {
            return null;
        }
        return info.instruction;
    }

    private static LabelInfo get(Label label) {
        Object info = label.info;
        if (info instanceof LabelInfo) {
            return (LabelInfo) info;
        }
        return null;
    }

    private static LabelInfo create(Label label) {
        LabelInfo info = get(label);
        if (info == null) {
            info = new LabelInfo();
            label.info = info;
        }
        return info;
    }
}
