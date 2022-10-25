package com.lagradost.nicehttp;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: lambda */
/* renamed from: com.lagradost.nicehttp.-$$Lambda$RequestsKt$bAfRwzknvdCXxHGMs-D5sJemaoQ  reason: invalid class name */
/* loaded from: classes4.dex */
public final /* synthetic */ class $$Lambda$RequestsKt$bAfRwzknvdCXxHGMsD5sJemaoQ implements HostnameVerifier {
    public static final /* synthetic */ $$Lambda$RequestsKt$bAfRwzknvdCXxHGMsD5sJemaoQ INSTANCE = new $$Lambda$RequestsKt$bAfRwzknvdCXxHGMsD5sJemaoQ();

    private /* synthetic */ $$Lambda$RequestsKt$bAfRwzknvdCXxHGMsD5sJemaoQ() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        boolean m9026ignoreAllSSLErrors$lambda10;
        m9026ignoreAllSSLErrors$lambda10 = RequestsKt.m9026ignoreAllSSLErrors$lambda10(str, sSLSession);
        return m9026ignoreAllSSLErrors$lambda10;
    }
}
