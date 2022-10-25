package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.api.AdEvent;
import com.google.ads.interactivemedia.p034v3.api.IMASDK;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.aic */
/* loaded from: classes2.dex */
public final class aic implements AdEvent {

    /* renamed from: a */
    private final AdEvent.AdEventType f4123a;

    /* renamed from: b */
    private final IMASDK f4124b;

    /* renamed from: c */
    private final Map f4125c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aic(AdEvent.AdEventType adEventType, IMASDK imasdk, Map map) {
        this.f4123a = adEventType;
        this.f4124b = imasdk;
        this.f4125c = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof aic) {
            aic aicVar = (aic) obj;
            return this.f4123a == aicVar.f4123a && anx.m4882b(this.f4124b, aicVar.f4124b) && anx.m4882b(this.f4125c, aicVar.f4125c);
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdEvent
    public final IMASDK getAd() {
        return this.f4124b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdEvent
    public final Map<String, String> getAdData() {
        return this.f4125c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.api.AdEvent
    public final AdEvent.AdEventType getType() {
        return this.f4123a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4123a, this.f4124b, this.f4125c});
    }

    public final String toString() {
        String format;
        String valueOf = String.valueOf(String.format("AdEvent[type=%s, ad=%s", this.f4123a, this.f4124b));
        if (this.f4125c == null) {
            format = "]";
        } else {
            Object[] objArr = new Object[1];
            StringBuilder sb = new StringBuilder("{");
            Iterator it = this.f4125c.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                sb.append((String) entry.getKey());
                sb.append(": ");
                sb.append((String) entry.getValue());
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
            sb.append("}");
            objArr[0] = sb.toString();
            format = String.format(", adData=%s]", objArr);
        }
        String valueOf2 = String.valueOf(format);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }
}
