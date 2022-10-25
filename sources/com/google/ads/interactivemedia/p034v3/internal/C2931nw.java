package com.google.ads.interactivemedia.p034v3.internal;

import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.nw */
/* loaded from: classes2.dex */
public final class C2931nw implements InterfaceC2663dy {

    /* renamed from: a */
    public static final boolean f8192a;

    /* renamed from: b */
    public final UUID f8193b;

    /* renamed from: c */
    public final byte[] f8194c;

    /* renamed from: d */
    public final boolean f8195d;

    static {
        boolean z = true;
        if (!"Amazon".equals(C2628cq.f6963c) || (!"AFTM".equals(C2628cq.f6964d) && !"AFTB".equals(C2628cq.f6964d))) {
            z = false;
        }
        f8192a = z;
    }

    public C2931nw(UUID uuid, byte[] bArr, boolean z) {
        this.f8193b = uuid;
        this.f8194c = bArr;
        this.f8195d = z;
    }
}
