package com.lagradost.cloudstream3.p041ui.player;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* compiled from: lambda */
/* renamed from: com.lagradost.cloudstream3.ui.player.-$$Lambda$CS3IPlayer$8b3TnVf7tccFRsf4O3iBf48LIBk  reason: invalid class name */
/* loaded from: classes3.dex */
public final /* synthetic */ class $$Lambda$CS3IPlayer$8b3TnVf7tccFRsf4O3iBf48LIBk implements HostnameVerifier {
    public static final /* synthetic */ $$Lambda$CS3IPlayer$8b3TnVf7tccFRsf4O3iBf48LIBk INSTANCE = new $$Lambda$CS3IPlayer$8b3TnVf7tccFRsf4O3iBf48LIBk();

    private /* synthetic */ $$Lambda$CS3IPlayer$8b3TnVf7tccFRsf4O3iBf48LIBk() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        boolean m8663loadOnlinePlayer$lambda16;
        m8663loadOnlinePlayer$lambda16 = CS3IPlayer.m8663loadOnlinePlayer$lambda16(str, sSLSession);
        return m8663loadOnlinePlayer$lambda16;
    }
}
