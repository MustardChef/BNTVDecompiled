package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.AdErrorEvent;
import java.util.ArrayList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aji */
/* loaded from: classes2.dex */
public final class aji {

    /* renamed from: a */
    private final List f4233a = new ArrayList(1);

    /* renamed from: a */
    public final void m5167a(AdErrorEvent.AdErrorListener adErrorListener) {
        this.f4233a.add(adErrorListener);
    }

    /* renamed from: b */
    public final void m5166b() {
        this.f4233a.clear();
    }

    /* renamed from: c */
    public final void m5165c(AdErrorEvent adErrorEvent) {
        for (AdErrorEvent.AdErrorListener adErrorListener : this.f4233a) {
            adErrorListener.onAdError(adErrorEvent);
        }
    }

    /* renamed from: d */
    public final void m5164d(AdErrorEvent.AdErrorListener adErrorListener) {
        this.f4233a.remove(adErrorListener);
    }

    public final String toString() {
        String obj = this.f4233a.toString();
        StringBuilder sb = new StringBuilder(obj.length() + 38);
        sb.append("ErrorListenerSupport [errorListeners=");
        sb.append(obj);
        sb.append("]");
        return sb.toString();
    }
}
