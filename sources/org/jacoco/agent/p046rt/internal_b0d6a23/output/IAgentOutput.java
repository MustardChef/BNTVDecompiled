package org.jacoco.agent.p046rt.internal_b0d6a23.output;

import java.io.IOException;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.output.IAgentOutput */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/output/IAgentOutput.class */
public interface IAgentOutput {
    void startup(AgentOptions agentOptions, RuntimeData runtimeData) throws Exception;

    void shutdown() throws Exception;

    void writeExecutionData(boolean z) throws IOException;
}
