package org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime;

import java.util.Random;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.runtime.AbstractRuntime */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/runtime/AbstractRuntime.class */
public abstract class AbstractRuntime implements IRuntime {
    protected RuntimeData data;
    private static final Random RANDOM = new Random();

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IRuntime
    public void startup(RuntimeData data) throws Exception {
        this.data = data;
    }

    public static String createRandomId() {
        return Integer.toHexString(RANDOM.nextInt());
    }
}
