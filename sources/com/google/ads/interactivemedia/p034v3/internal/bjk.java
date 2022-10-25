package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bjk */
/* loaded from: classes2.dex */
final class bjk extends bgy {
    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ Object read(bkv bkvVar) throws IOException {
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bgy
    public final /* bridge */ /* synthetic */ void write(bkx bkxVar, Object obj) throws IOException {
        String name = ((Class) obj).getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 76);
        sb.append("Attempted to serialize java.lang.Class: ");
        sb.append(name);
        sb.append(". Forgot to register a type adapter?");
        throw new UnsupportedOperationException(sb.toString());
    }
}
