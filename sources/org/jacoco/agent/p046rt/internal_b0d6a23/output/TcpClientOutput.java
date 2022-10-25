package org.jacoco.agent.p046rt.internal_b0d6a23.output;

import java.io.IOException;
import java.net.Socket;
import org.jacoco.agent.p046rt.internal_b0d6a23.IExceptionLogger;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.output.TcpClientOutput */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/output/TcpClientOutput.class */
public class TcpClientOutput implements IAgentOutput {
    private final IExceptionLogger logger;
    private TcpConnection connection;
    private Thread worker;

    public TcpClientOutput(IExceptionLogger logger) {
        this.logger = logger;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.output.IAgentOutput
    public void startup(AgentOptions options, RuntimeData data) throws IOException {
        Socket socket = createSocket(options);
        this.connection = new TcpConnection(socket, data);
        this.connection.init();
        this.worker = new Thread(new Runnable() { // from class: org.jacoco.agent.rt.internal_b0d6a23.output.TcpClientOutput.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TcpClientOutput.this.connection.run();
                } catch (IOException e) {
                    TcpClientOutput.this.logger.logExeption(e);
                }
            }
        });
        this.worker.setName(getClass().getName());
        this.worker.setDaemon(true);
        this.worker.start();
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.output.IAgentOutput
    public void shutdown() throws Exception {
        this.connection.close();
        this.worker.join();
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.output.IAgentOutput
    public void writeExecutionData(boolean reset) throws IOException {
        this.connection.writeExecutionData(reset);
    }

    protected Socket createSocket(AgentOptions options) throws IOException {
        return new Socket(options.getAddress(), options.getPort());
    }
}
