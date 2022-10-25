package com.google.common.p039io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.common.io.MultiReader */
/* loaded from: classes3.dex */
class MultiReader extends Reader {
    @NullableDecl
    private Reader current;

    /* renamed from: it */
    private final Iterator<? extends CharSource> f9836it;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiReader(Iterator<? extends CharSource> it) throws IOException {
        this.f9836it = it;
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.f9836it.hasNext()) {
            this.current = this.f9836it.next().openStream();
        }
    }

    @Override // java.io.Reader
    public int read(@NullableDecl char[] cArr, int i, int i2) throws IOException {
        Reader reader = this.current;
        if (reader == null) {
            return -1;
        }
        int read = reader.read(cArr, i, i2);
        if (read == -1) {
            advance();
            return read(cArr, i, i2);
        }
        return read;
    }

    @Override // java.io.Reader
    public long skip(long j) throws IOException {
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        Preconditions.checkArgument(i >= 0, "n is negative");
        if (i > 0) {
            while (true) {
                Reader reader = this.current;
                if (reader == null) {
                    break;
                }
                long skip = reader.skip(j);
                if (skip > 0) {
                    return skip;
                }
                advance();
            }
        }
        return 0L;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.current;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader reader = this.current;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.current = null;
            }
        }
    }
}
