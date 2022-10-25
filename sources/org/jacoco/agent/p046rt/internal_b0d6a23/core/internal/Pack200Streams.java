package org.jacoco.agent.p046rt.internal_b0d6a23.core.internal;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;

/* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.Pack200Streams */
/* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/Pack200Streams.class */
public final class Pack200Streams {
    public static InputStream unpack(InputStream input) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        JarOutputStream jar = new JarOutputStream(buffer);
        Pack200.newUnpacker().unpack(new NoCloseInput(input), jar);
        jar.finish();
        return new ByteArrayInputStream(buffer.toByteArray());
    }

    public static void pack(byte[] source, OutputStream output) throws IOException {
        JarInputStream jar = new JarInputStream(new ByteArrayInputStream(source));
        Pack200.newPacker().pack(jar, output);
    }

    /* renamed from: org.jacoco.agent.rt.internal_b0d6a23.core.internal.Pack200Streams$NoCloseInput */
    /* loaded from: 5.6.84.apk:jacocoagent.jar:org/jacoco/agent/rt/internal_b0d6a23/core/internal/Pack200Streams$NoCloseInput.class */
    private static class NoCloseInput extends FilterInputStream {
        protected NoCloseInput(InputStream in) {
            super(in);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    private Pack200Streams() {
    }
}
