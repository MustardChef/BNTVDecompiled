package androidx.work.impl;

/* loaded from: classes.dex */
public interface ExecutionListener {
    void onExecuted(String workSpecId, boolean needsReschedule);
}
