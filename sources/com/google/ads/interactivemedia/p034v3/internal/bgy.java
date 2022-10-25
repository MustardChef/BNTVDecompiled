package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bgy */
/* loaded from: classes2.dex */
public abstract class bgy<T> {
    public final T fromJson(Reader reader) throws IOException {
        return read(new bkv(reader));
    }

    public final T fromJsonTree(bgm bgmVar) {
        try {
            return read(new bin(bgmVar));
        } catch (IOException e) {
            throw new bgn(e);
        }
    }

    public final bgy<T> nullSafe() {
        return new bgx(this);
    }

    public abstract T read(bkv bkvVar) throws IOException;

    public final void toJson(Writer writer, T t) throws IOException {
        write(new bkx(writer), t);
    }

    public final bgm toJsonTree(T t) {
        try {
            bip bipVar = new bip();
            write(bipVar, t);
            return bipVar.m3630a();
        } catch (IOException e) {
            throw new bgn(e);
        }
    }

    public abstract void write(bkx bkxVar, T t) throws IOException;

    public final T fromJson(String str) throws IOException {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
