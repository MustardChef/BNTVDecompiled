package com.google.common.p039io;

import com.google.common.base.Preconditions;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/* renamed from: com.google.common.io.CharSink */
/* loaded from: classes3.dex */
public abstract class CharSink {
    public abstract Writer openStream() throws IOException;

    public Writer openBufferedStream() throws IOException {
        Writer openStream = openStream();
        return openStream instanceof BufferedWriter ? (BufferedWriter) openStream : new BufferedWriter(openStream);
    }

    public void write(CharSequence charSequence) throws IOException {
        Preconditions.checkNotNull(charSequence);
        try {
            Writer writer = (Writer) Closer.create().register(openStream());
            writer.append(charSequence);
            writer.flush();
        } finally {
        }
    }

    public void writeLines(Iterable<? extends CharSequence> iterable) throws IOException {
        writeLines(iterable, System.getProperty("line.separator"));
    }

    public void writeLines(Iterable<? extends CharSequence> iterable, String str) throws IOException {
        Preconditions.checkNotNull(iterable);
        Preconditions.checkNotNull(str);
        try {
            Writer writer = (Writer) Closer.create().register(openBufferedStream());
            for (CharSequence charSequence : iterable) {
                writer.append(charSequence).append((CharSequence) str);
            }
            writer.flush();
        } finally {
        }
    }

    public long writeFrom(Readable readable) throws IOException {
        Preconditions.checkNotNull(readable);
        try {
            Writer writer = (Writer) Closer.create().register(openStream());
            long copy = CharStreams.copy(readable, writer);
            writer.flush();
            return copy;
        } finally {
        }
    }
}
