package org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime;

import java.io.IOException;
import java.io.OutputStream;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.data.ExecutionDataWriter;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.runtime.RemoteControlWriter */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/runtime/RemoteControlWriter.class */
public class RemoteControlWriter extends ExecutionDataWriter implements IRemoteCommandVisitor {
    public static final byte BLOCK_CMDOK = 32;
    public static final byte BLOCK_CMDDUMP = 64;

    public RemoteControlWriter(OutputStream output) throws IOException {
        super(output);
    }

    public void sendCmdOk() throws IOException {
        this.out.writeByte(32);
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IRemoteCommandVisitor
    public void visitDumpCommand(boolean dump, boolean reset) throws IOException {
        this.out.writeByte(64);
        this.out.writeBoolean(dump);
        this.out.writeBoolean(reset);
    }
}
