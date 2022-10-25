package com.google.ads.interactivemedia.p034v3.internal;

import com.facebook.internal.AnalyticsEvents;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agn */
/* loaded from: classes2.dex */
public enum agn {
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript"),
    NONE("none");
    

    /* renamed from: e */
    private final String f4003e;

    agn(String str) {
        this.f4003e = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f4003e;
    }
}
