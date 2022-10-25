package org.jacoco.agent.p046rt.internal_b0d6a23.core.data;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.data.CompactDataInput;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.data.ExecutionDataReader */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/data/ExecutionDataReader.class */
public class ExecutionDataReader {

    /* renamed from: in */
    protected final CompactDataInput f10705in;
    private ISessionInfoVisitor sessionInfoVisitor = null;
    private IExecutionDataVisitor executionDataVisitor = null;
    private boolean firstBlock = true;

    public ExecutionDataReader(InputStream input) {
        this.f10705in = new CompactDataInput(input);
    }

    public void setSessionInfoVisitor(ISessionInfoVisitor visitor) {
        this.sessionInfoVisitor = visitor;
    }

    public void setExecutionDataVisitor(IExecutionDataVisitor visitor) {
        this.executionDataVisitor = visitor;
    }

    public boolean read() throws IOException {
        byte type;
        do {
            try {
                type = this.f10705in.readByte();
                if (this.firstBlock && type != 1) {
                    throw new IOException("Invalid execution data file.");
                }
                this.firstBlock = false;
            } catch (EOFException e) {
                return false;
            }
        } while (readBlock(type));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean readBlock(byte blocktype) throws IOException {
        switch (blocktype) {
            case 1:
                readHeader();
                return true;
            case 16:
                readSessionInfo();
                return true;
            case 17:
                readExecutionData();
                return true;
            default:
                throw new IOException(String.format("Unknown block type %x.", Byte.valueOf(blocktype)));
        }
    }

    private void readHeader() throws IOException {
        if (this.f10705in.readChar() != 49344) {
            throw new IOException("Invalid execution data file.");
        }
        char version = this.f10705in.readChar();
        if (version != 4103) {
            throw new IOException(String.format("Incompatible version %x.", Integer.valueOf(version)));
        }
    }

    private void readSessionInfo() throws IOException {
        if (this.sessionInfoVisitor == null) {
            throw new IOException("No session info visitor.");
        }
        String id = this.f10705in.readUTF();
        long start = this.f10705in.readLong();
        long dump = this.f10705in.readLong();
        this.sessionInfoVisitor.visitSessionInfo(new SessionInfo(id, start, dump));
    }

    private void readExecutionData() throws IOException {
        if (this.executionDataVisitor == null) {
            throw new IOException("No execution data visitor.");
        }
        long id = this.f10705in.readLong();
        String name = this.f10705in.readUTF();
        boolean[] probes = this.f10705in.readBooleanArray();
        this.executionDataVisitor.visitClassExecution(new ExecutionData(id, name, probes));
    }
}
