package org.jacoco.agent.p046rt.internal_b0d6a23.core.data;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.data.CompactDataOutput;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.data.ExecutionDataWriter */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/data/ExecutionDataWriter.class */
public class ExecutionDataWriter implements ISessionInfoVisitor, IExecutionDataVisitor {
    public static final char FORMAT_VERSION = 4103;
    public static final char MAGIC_NUMBER = 49344;
    public static final byte BLOCK_HEADER = 1;
    public static final byte BLOCK_SESSIONINFO = 16;
    public static final byte BLOCK_EXECUTIONDATA = 17;
    protected final CompactDataOutput out;

    public ExecutionDataWriter(OutputStream output) throws IOException {
        this.out = new CompactDataOutput(output);
        writeHeader();
    }

    private void writeHeader() throws IOException {
        this.out.writeByte(1);
        this.out.writeChar(MAGIC_NUMBER);
        this.out.writeChar(FORMAT_VERSION);
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.data.ISessionInfoVisitor
    public void visitSessionInfo(SessionInfo info) {
        try {
            this.out.writeByte(16);
            this.out.writeUTF(info.getId());
            this.out.writeLong(info.getStartTimeStamp());
            this.out.writeLong(info.getDumpTimeStamp());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.core.data.IExecutionDataVisitor
    public void visitClassExecution(ExecutionData data) {
        try {
            this.out.writeByte(17);
            this.out.writeLong(data.getId());
            this.out.writeUTF(data.getName());
            this.out.writeBooleanArray(data.getProbes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static final byte[] getFileHeader() {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try {
            new ExecutionDataWriter(buffer);
            return buffer.toByteArray();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
