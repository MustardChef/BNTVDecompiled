package com.google.android.gms.internal.firebase_messaging;

import java.io.OutputStream;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.1 */
/* loaded from: classes3.dex */
final class zze extends OutputStream {
    public final String toString() {
        return "ByteStreams.nullOutputStream()";
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        Objects.requireNonNull(bArr);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        Objects.requireNonNull(bArr);
    }
}
