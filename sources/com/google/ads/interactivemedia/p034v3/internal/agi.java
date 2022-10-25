package com.google.ads.interactivemedia.p034v3.internal;

import com.facebook.internal.AnalyticsEvents;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.agi */
/* loaded from: classes2.dex */
public enum agi {
    HTML("html"),
    NATIVE(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE),
    JAVASCRIPT("javascript");
    

    /* renamed from: e */
    private final String f3968e;

    agi(String str) {
        this.f3968e = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f3968e;
    }
}
