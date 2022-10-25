package org.jacoco.agent.p046rt.internal_b0d6a23;

import java.lang.instrument.Instrumentation;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IRuntime;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.ModifiedSystemClassRuntime;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.PreMain */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/PreMain.class */
public final class PreMain {
    private PreMain() {
    }

    public static void premain(String options, Instrumentation inst) throws Exception {
        AgentOptions agentOptions = new AgentOptions(options);
        Agent agent = Agent.getInstance(agentOptions);
        IRuntime runtime = createRuntime(inst);
        runtime.startup(agent.getData());
        inst.addTransformer(new CoverageTransformer(runtime, agentOptions, IExceptionLogger.SYSTEM_ERR));
    }

    private static IRuntime createRuntime(Instrumentation inst) throws Exception {
        return ModifiedSystemClassRuntime.createFor(inst, "java/util/UUID");
    }
}
