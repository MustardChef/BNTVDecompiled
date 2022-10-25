package org.jacoco.agent.p046rt.internal_b0d6a23.core.instr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassReader;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassVisitor;
import org.jacoco.agent.p046rt.internal_b0d6a23.asm.ClassWriter;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.ContentTypeDetector;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.Pack200Streams;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.flow.ClassProbesAdapter;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.ClassInstrumenter;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.IProbeArrayStrategy;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.ProbeArrayStrategyFactory;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.internal.instr.SignatureRemover;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.IExecutionDataAccessorGenerator;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.instr.Instrumenter */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/instr/Instrumenter.class */
public class Instrumenter {
    private final IExecutionDataAccessorGenerator accessorGenerator;
    private final SignatureRemover signatureRemover = new SignatureRemover();

    public Instrumenter(IExecutionDataAccessorGenerator runtime) {
        this.accessorGenerator = runtime;
    }

    public void setRemoveSignatures(boolean flag) {
        this.signatureRemover.setActive(flag);
    }

    public byte[] instrument(ClassReader reader) {
        ClassWriter writer = new ClassWriter(reader, 0);
        IProbeArrayStrategy strategy = ProbeArrayStrategyFactory.createFor(reader, this.accessorGenerator);
        ClassVisitor visitor = new ClassProbesAdapter(new ClassInstrumenter(strategy, writer), true);
        reader.accept(visitor, 8);
        return writer.toByteArray();
    }

    public byte[] instrument(byte[] buffer, String name) throws IOException {
        try {
            return instrument(new ClassReader(buffer));
        } catch (RuntimeException e) {
            throw instrumentError(name, e);
        }
    }

    public byte[] instrument(InputStream input, String name) throws IOException {
        try {
            return instrument(new ClassReader(input));
        } catch (RuntimeException e) {
            throw instrumentError(name, e);
        }
    }

    public void instrument(InputStream input, OutputStream output, String name) throws IOException {
        try {
            output.write(instrument(new ClassReader(input)));
        } catch (RuntimeException e) {
            throw instrumentError(name, e);
        }
    }

    private IOException instrumentError(String name, RuntimeException cause) {
        IOException ex = new IOException(String.format("Error while instrumenting class %s.", name));
        ex.initCause(cause);
        return ex;
    }

    public int instrumentAll(InputStream input, OutputStream output, String name) throws IOException {
        ContentTypeDetector detector = new ContentTypeDetector(input);
        switch (detector.getType()) {
            case ContentTypeDetector.CLASSFILE /* -889275714 */:
                instrument(detector.getInputStream(), output, name);
                return 1;
            case ContentTypeDetector.PACK200FILE /* -889270259 */:
                return instrumentPack200(detector.getInputStream(), output, name);
            case ContentTypeDetector.GZFILE /* 529203200 */:
                return instrumentGzip(detector.getInputStream(), output, name);
            case ContentTypeDetector.ZIPFILE /* 1347093252 */:
                return instrumentZip(detector.getInputStream(), output, name);
            default:
                copy(detector.getInputStream(), output);
                return 0;
        }
    }

    private int instrumentZip(InputStream input, OutputStream output, String name) throws IOException {
        ZipInputStream zipin = new ZipInputStream(input);
        ZipOutputStream zipout = new ZipOutputStream(output);
        int count = 0;
        while (true) {
            ZipEntry entry = zipin.getNextEntry();
            if (entry != null) {
                String entryName = entry.getName();
                if (!this.signatureRemover.removeEntry(entryName)) {
                    zipout.putNextEntry(new ZipEntry(entryName));
                    if (!this.signatureRemover.filterEntry(entryName, zipin, zipout)) {
                        count += instrumentAll(zipin, zipout, name + "@" + entryName);
                    }
                    zipout.closeEntry();
                }
            } else {
                zipout.finish();
                return count;
            }
        }
    }

    private int instrumentGzip(InputStream input, OutputStream output, String name) throws IOException {
        GZIPOutputStream gzout = new GZIPOutputStream(output);
        int count = instrumentAll(new GZIPInputStream(input), gzout, name);
        gzout.finish();
        return count;
    }

    private int instrumentPack200(InputStream input, OutputStream output, String name) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int count = instrumentAll(Pack200Streams.unpack(input), buffer, name);
        Pack200Streams.pack(buffer.toByteArray(), output);
        return count;
    }

    private void copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[1024];
        while (true) {
            int len = input.read(buffer);
            if (len != -1) {
                output.write(buffer, 0, len);
            } else {
                return;
            }
        }
    }
}
