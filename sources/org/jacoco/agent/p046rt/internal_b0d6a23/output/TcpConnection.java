package org.jacoco.agent.p046rt.internal_b0d6a23.output;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IRemoteCommandVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.RemoteControlReader;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.RemoteControlWriter;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.RuntimeData;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.output.TcpConnection */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/output/TcpConnection.class */
public class TcpConnection implements IRemoteCommandVisitor {
    private final RuntimeData data;
    private final Socket socket;
    private RemoteControlWriter writer;
    private RemoteControlReader reader;
    private boolean initialized = false;

    public TcpConnection(Socket socket, RuntimeData data) {
        this.socket = socket;
        this.data = data;
    }

    public void init() throws IOException {
        this.writer = new RemoteControlWriter(this.socket.getOutputStream());
        this.reader = new RemoteControlReader(this.socket.getInputStream());
        this.reader.setRemoteCommandVisitor(this);
        this.initialized = true;
    }

    public void run() throws IOException {
        while (this.reader.read()) {
            try {
                try {
                } catch (SocketException e) {
                    if (!this.socket.isClosed()) {
                        throw e;
                    }
                    close();
                    return;
                }
            } catch (Throwable th) {
                close();
                throw th;
            }
        }
        close();
    }

    public void writeExecutionData(boolean reset) throws IOException {
        if (this.initialized && !this.socket.isClosed()) {
            visitDumpCommand(true, reset);
        }
    }

    public void close() throws IOException {
        if (!this.socket.isClosed()) {
            this.socket.close();
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IRemoteCommandVisitor
    public void visitDumpCommand(boolean dump, boolean reset) throws IOException {
        if (dump) {
            this.data.collect(this.writer, this.writer, reset);
        } else if (reset) {
            this.data.reset();
        }
        this.writer.sendCmdOk();
    }
}
