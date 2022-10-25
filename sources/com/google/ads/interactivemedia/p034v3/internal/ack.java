package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.util.MimeTypes;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ack */
/* loaded from: classes2.dex */
final class ack {

    /* renamed from: a */
    public final acp f3199a;

    /* renamed from: b */
    public final acs f3200b;

    /* renamed from: c */
    public final InterfaceC3253zu f3201c;

    /* renamed from: d */
    public final C3254zv f3202d;

    /* renamed from: e */
    public int f3203e;

    public ack(acp acpVar, acs acsVar, InterfaceC3253zu interfaceC3253zu) {
        this.f3199a = acpVar;
        this.f3200b = acsVar;
        this.f3201c = interfaceC3253zu;
        this.f3202d = MimeTypes.AUDIO_TRUEHD.equals(acpVar.f3235f.f8372l) ? new C3254zv() : null;
    }
}
