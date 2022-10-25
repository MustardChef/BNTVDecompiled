package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.w */
/* loaded from: classes2.dex */
public final class C3151w {

    /* renamed from: a */
    private UUID f9258a;

    /* renamed from: b */
    private Uri f9259b;

    /* renamed from: c */
    private final avj f9260c;

    /* renamed from: d */
    private final avg f9261d;

    /* renamed from: e */
    private byte[] f9262e;

    @Deprecated
    private C3151w() {
        this.f9260c = avj.m4504d();
        this.f9261d = avg.m4515n();
    }

    public /* synthetic */ C3151w(C3178x c3178x) {
        byte[] bArr;
        this.f9258a = c3178x.f9342a;
        this.f9259b = null;
        this.f9260c = c3178x.f9344c;
        this.f9261d = c3178x.f9348g;
        bArr = c3178x.f9349h;
        this.f9262e = bArr;
    }

    /* renamed from: c */
    public static /* bridge */ /* synthetic */ UUID m772c(C3151w c3151w) {
        return c3151w.f9258a;
    }

    /* renamed from: e */
    public static /* bridge */ /* synthetic */ void m770e(C3151w c3151w) {
        Uri uri = c3151w.f9259b;
    }

    public /* synthetic */ C3151w(byte[] bArr) {
        this.f9260c = avj.m4504d();
        this.f9261d = avg.m4515n();
    }
}
