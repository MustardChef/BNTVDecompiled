package org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime;

import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.data.ExecutionDataReader;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.runtime.RemoteControlReader */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/runtime/RemoteControlReader.class */
public class RemoteControlReader extends ExecutionDataReader {
    private IRemoteCommandVisitor remoteCommandVisitor;

    public RemoteControlReader(InputStream input) throws IOException {
        super(input);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.data.ExecutionDataReader
    public boolean readBlock(byte blockid) throws IOException {
        switch (blockid) {
            case 32:
                return false;
            case 64:
                readDumpCommand();
                return true;
            default:
                return super.readBlock(blockid);
        }
    }

    public void setRemoteCommandVisitor(IRemoteCommandVisitor visitor) {
        this.remoteCommandVisitor = visitor;
    }

    private void readDumpCommand() throws IOException {
        if (this.remoteCommandVisitor == null) {
            throw new IOException("No remote command visitor.");
        }
        boolean dump = this.f10705in.readBoolean();
        boolean reset = this.f10705in.readBoolean();
        this.remoteCommandVisitor.visitDumpCommand(dump, reset);
    }
}
