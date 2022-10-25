package com.google.ads.interactivemedia.p034v3.internal;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.arv */
/* loaded from: classes2.dex */
public final class arv {

    /* renamed from: a */
    private final String f4955a;

    /* renamed from: b */
    private final boolean f4956b;

    /* renamed from: c */
    private final boolean f4957c;

    public arv() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ arv(String str, boolean z, boolean z2) {
        this();
        this.f4955a = str;
        this.f4956b = z;
        this.f4957c = z2;
    }

    /* renamed from: a */
    public static aru m4717a() {
        aru aruVar = new aru(null);
        aruVar.m4718d(false);
        aruVar.m4719c();
        return aruVar;
    }

    /* renamed from: b */
    public final String m4716b() {
        return this.f4955a;
    }

    /* renamed from: c */
    public final boolean m4715c() {
        return this.f4957c;
    }

    /* renamed from: d */
    public final boolean m4714d() {
        return this.f4956b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof arv) {
            arv arvVar = (arv) obj;
            if (this.f4955a.equals(arvVar.m4716b()) && this.f4956b == arvVar.m4714d() && this.f4957c == arvVar.m4715c()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f4955a.hashCode() ^ 1000003) * 1000003) ^ (true != this.f4956b ? 1237 : 1231)) * 1000003) ^ (true == this.f4957c ? 1231 : 1237);
    }

    public final String toString() {
        String str = this.f4955a;
        boolean z = this.f4956b;
        boolean z2 = this.f4957c;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 99);
        sb.append("AdShield2Options{clientVersion=");
        sb.append(str);
        sb.append(", shouldGetAdvertisingId=");
        sb.append(z);
        sb.append(", isGooglePlayServicesAvailable=");
        sb.append(z2);
        sb.append("}");
        return sb.toString();
    }
}
