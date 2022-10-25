package com.google.ads.interactivemedia.p034v3.internal;

import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.qy */
/* loaded from: classes2.dex */
public final class C3014qy {

    /* renamed from: a */
    public final C3019rc f8670a;

    /* renamed from: b */
    public final MediaFormat f8671b;

    /* renamed from: c */
    public final C2962p f8672c;

    /* renamed from: d */
    public final Surface f8673d;

    /* renamed from: e */
    public final MediaCrypto f8674e;

    private C3014qy(C3019rc c3019rc, MediaFormat mediaFormat, C2962p c2962p, Surface surface, MediaCrypto mediaCrypto) {
        this.f8670a = c3019rc;
        this.f8671b = mediaFormat;
        this.f8672c = c2962p;
        this.f8673d = surface;
        this.f8674e = mediaCrypto;
    }

    /* renamed from: a */
    public static C3014qy m1264a(C3019rc c3019rc, MediaFormat mediaFormat, C2962p c2962p, MediaCrypto mediaCrypto) {
        return new C3014qy(c3019rc, mediaFormat, c2962p, null, mediaCrypto);
    }

    /* renamed from: b */
    public static C3014qy m1263b(C3019rc c3019rc, MediaFormat mediaFormat, C2962p c2962p, Surface surface, MediaCrypto mediaCrypto) {
        return new C3014qy(c3019rc, mediaFormat, c2962p, surface, mediaCrypto);
    }
}
