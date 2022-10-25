package com.google.ads.interactivemedia.p034v3.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bos */
/* loaded from: classes2.dex */
public final class bos implements bog {

    /* renamed from: a */
    private final boj f6349a;

    /* renamed from: b */
    private final String f6350b;

    /* renamed from: c */
    private final Object[] f6351c;

    /* renamed from: d */
    private final int f6352d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bos(boj bojVar, String str, Object[] objArr) {
        this.f6349a = bojVar;
        this.f6350b = str;
        this.f6351c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f6352d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.f6352d = i | (charAt2 << i2);
                return;
            }
            i |= (charAt2 & 8191) << i2;
            i2 += 13;
            i3 = i4;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bog
    /* renamed from: a */
    public final boj mo2955a() {
        return this.f6349a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bog
    /* renamed from: b */
    public final boolean mo2954b() {
        return (this.f6352d & 2) == 2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bog
    /* renamed from: c */
    public final int mo2953c() {
        return (this.f6352d & 1) == 1 ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public final String m3113d() {
        return this.f6350b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public final Object[] m3112e() {
        return this.f6351c;
    }
}
