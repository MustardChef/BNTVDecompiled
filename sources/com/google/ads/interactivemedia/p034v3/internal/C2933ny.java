package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import java.util.UUID;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ny */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2933ny {

    /* renamed from: a */
    public static final /* synthetic */ C2933ny f8198a = new C2933ny();

    private /* synthetic */ C2933ny() {
    }

    /* renamed from: a */
    public final InterfaceC2930nv m1565a(UUID uuid) {
        try {
            return C2936oa.m1488n(uuid);
        } catch (C2941of unused) {
            String valueOf = String.valueOf(uuid);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 53);
            sb.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
            sb.append(valueOf);
            sb.append(".");
            Log.e("FrameworkMediaDrm", sb.toString());
            return new C2926nr();
        }
    }
}
