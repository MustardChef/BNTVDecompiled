package com.google.ads.interactivemedia.p034v3.internal;

import android.text.TextUtils;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.rk */
/* loaded from: classes2.dex */
final class C3027rk {

    /* renamed from: a */
    public final String f8764a;

    /* renamed from: b */
    public final boolean f8765b;

    /* renamed from: c */
    public final boolean f8766c;

    public C3027rk(String str, boolean z, boolean z2) {
        this.f8764a = str;
        this.f8765b = z;
        this.f8766c = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == C3027rk.class) {
            C3027rk c3027rk = (C3027rk) obj;
            if (TextUtils.equals(this.f8764a, c3027rk.f8764a) && this.f8765b == c3027rk.f8765b && this.f8766c == c3027rk.f8766c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f8764a.hashCode() + 31) * 31) + (true != this.f8765b ? 1237 : 1231)) * 31) + (true == this.f8766c ? 1231 : 1237);
    }
}
