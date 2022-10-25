package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.abx */
/* loaded from: classes2.dex */
public final class abx implements abv {

    /* renamed from: a */
    private final int f3121a;

    /* renamed from: b */
    private final int f3122b;

    /* renamed from: c */
    private final C2621cj f3123c;

    public abx(abs absVar, C2962p c2962p) {
        C2621cj c2621cj = absVar.f3106a;
        this.f3123c = c2621cj;
        c2621cj.m2644F(12);
        int m2630l = c2621cj.m2630l();
        if (MimeTypes.AUDIO_RAW.equals(c2962p.f8372l)) {
            int m2523k = C2628cq.m2523k(c2962p.f8355A, c2962p.f8385y);
            if (m2630l == 0 || m2630l % m2523k != 0) {
                StringBuilder sb = new StringBuilder(88);
                sb.append("Audio sample size mismatch. stsd sample size: ");
                sb.append(m2523k);
                sb.append(", stsz sample size: ");
                sb.append(m2630l);
                Log.w("AtomParsers", sb.toString());
                m2630l = m2523k;
            }
        }
        this.f3121a = m2630l == 0 ? -1 : m2630l;
        this.f3122b = c2621cj.m2630l();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abv
    /* renamed from: a */
    public final int mo5885a() {
        return this.f3121a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abv
    /* renamed from: b */
    public final int mo5884b() {
        return this.f3122b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.abv
    /* renamed from: c */
    public final int mo5883c() {
        int i = this.f3121a;
        return i == -1 ? this.f3123c.m2630l() : i;
    }
}
