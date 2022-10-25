package org.jacoco.agent.p046rt.internal_b0d6a23;

import java.util.Properties;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.Offline */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/Offline.class */
public final class Offline {
    private static final RuntimeData DATA;
    private static final String CONFIG_RESOURCE = "/jacoco-agent.properties";

    static {
        Properties config = ConfigLoader.load(CONFIG_RESOURCE, System.getProperties());
        DATA = Agent.getInstance(new AgentOptions(config)).getData();
    }

    private Offline() {
    }

    public static boolean[] getProbes(long classid, String classname, int probecount) {
        return DATA.getExecutionData(Long.valueOf(classid), classname, probecount).getProbes();
    }
}
