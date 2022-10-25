package org.jacoco.agent.p046rt.internal_b0d6a23.output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.data.ExecutionDataWriter;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.RuntimeData;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.output.FileOutput */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/output/FileOutput.class */
public class FileOutput implements IAgentOutput {
    private RuntimeData data;
    private File destFile;
    private boolean append;

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.output.IAgentOutput
    public final void startup(AgentOptions options, RuntimeData data) throws IOException {
        this.data = data;
        this.destFile = new File(options.getDestfile()).getAbsoluteFile();
        this.append = options.getAppend();
        File folder = this.destFile.getParentFile();
        if (folder != null) {
            folder.mkdirs();
        }
        openFile().close();
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.output.IAgentOutput
    public void writeExecutionData(boolean reset) throws IOException {
        OutputStream output = openFile();
        try {
            ExecutionDataWriter writer = new ExecutionDataWriter(output);
            this.data.collect(writer, writer, reset);
            output.close();
        } catch (Throwable th) {
            output.close();
            throw th;
        }
    }

    @Override // org.jacoco.agent.p046rt.internal_b0d6a23.output.IAgentOutput
    public void shutdown() throws IOException {
    }

    private OutputStream openFile() throws IOException {
        FileOutputStream file = new FileOutputStream(this.destFile, this.append);
        file.getChannel().lock();
        return file;
    }
}
