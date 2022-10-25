package org.jacoco.agent.p046rt.internal_b0d6a23.output;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import org.jacoco.agent.p046rt.internal_b0d6a23.IExceptionLogger;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.output.TcpServerOutput */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/output/TcpServerOutput.class */
public class TcpServerOutput implements IAgentOutput {
    private TcpConnection connection;
    private final IExceptionLogger logger;
    private ServerSocket serverSocket;
    private Thread worker;

    public TcpServerOutput(IExceptionLogger logger) {
        this.logger = logger;
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.output.IAgentOutput
    public void startup(AgentOptions options, final RuntimeData data) throws IOException {
        this.serverSocket = createServerSocket(options);
        this.worker = new Thread(new Runnable() { // from class: org.jacoco.agent.rt.internal_b0d6a23.output.TcpServerOutput.1
            @Override // java.lang.Runnable
            public void run() {
                while (!TcpServerOutput.this.serverSocket.isClosed()) {
                    try {
                        synchronized (TcpServerOutput.this.serverSocket) {
                            TcpServerOutput.this.connection = new TcpConnection(TcpServerOutput.this.serverSocket.accept(), data);
                        }
                        TcpServerOutput.this.connection.init();
                        TcpServerOutput.this.connection.run();
                    } catch (IOException e) {
                        if (!TcpServerOutput.this.serverSocket.isClosed()) {
                            TcpServerOutput.this.logger.logExeption(e);
                        }
                    }
                }
            }
        });
        this.worker.setName(getClass().getName());
        this.worker.setDaemon(true);
        this.worker.start();
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.output.IAgentOutput
    public void shutdown() throws Exception {
        this.serverSocket.close();
        synchronized (this.serverSocket) {
            if (this.connection != null) {
                this.connection.close();
            }
        }
        this.worker.join();
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.output.IAgentOutput
    public void writeExecutionData(boolean reset) throws IOException {
        if (this.connection != null) {
            this.connection.writeExecutionData(reset);
        }
    }

    protected ServerSocket createServerSocket(AgentOptions options) throws IOException {
        InetAddress inetAddr = getInetAddress(options.getAddress());
        return new ServerSocket(options.getPort(), 1, inetAddr);
    }

    protected InetAddress getInetAddress(String address) throws UnknownHostException {
        if ("*".equals(address)) {
            return null;
        }
        return InetAddress.getByName(address);
    }
}
