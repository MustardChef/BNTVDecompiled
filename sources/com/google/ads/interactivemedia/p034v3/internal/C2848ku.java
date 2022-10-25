package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ku */
/* loaded from: classes2.dex */
final class C2848ku implements InterfaceC3169wr {
    private C2848ku() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2848ku(byte[] bArr) {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3169wr
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ Object mo714a(Uri uri, InputStream inputStream) throws IOException {
        return Long.valueOf(C2628cq.m2514t(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
    }
}
