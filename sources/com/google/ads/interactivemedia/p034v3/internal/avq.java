package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.avq */
/* loaded from: classes2.dex */
public final class avq extends avh {

    /* renamed from: c */
    private transient Object[] f5184c;

    /* renamed from: d */
    private transient Object[] f5185d;

    /* renamed from: e */
    private final Comparator f5186e;

    public avq(Comparator comparator) {
        atm.m4612j(comparator);
        this.f5186e = comparator;
        this.f5184c = new Object[4];
        this.f5185d = new Object[4];
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avh
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ avh mo4491a(Object obj, Object obj2) {
        int i = this.f5173b + 1;
        int length = this.f5184c.length;
        if (i > length) {
            int m4527a = ava.m4527a(length, i);
            this.f5184c = Arrays.copyOf(this.f5184c, m4527a);
            this.f5185d = Arrays.copyOf(this.f5185d, m4527a);
        }
        axd.m4415G(obj, obj2);
        Object[] objArr = this.f5184c;
        int i2 = this.f5173b;
        objArr[i2] = obj;
        this.f5185d[i2] = obj2;
        this.f5173b = i2 + 1;
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avh
    /* renamed from: d */
    public final /* synthetic */ void mo4488d(Map.Entry entry) {
        super.mo4488d(entry);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.avh
    /* renamed from: f */
    public final avs mo4489c() {
        int i = this.f5173b;
        if (i != 0) {
            if (i == 1) {
                Comparator comparator = this.f5186e;
                Object obj = this.f5184c[0];
                obj.getClass();
                Object obj2 = this.f5185d[0];
                obj2.getClass();
                avg m4514o = avg.m4514o(obj);
                atm.m4612j(comparator);
                return new avs(new awx(m4514o, comparator), avg.m4514o(obj2));
            }
            Object[] copyOf = Arrays.copyOf(this.f5184c, i);
            Arrays.sort(copyOf, this.f5186e);
            Object[] objArr = new Object[this.f5173b];
            for (int i2 = 0; i2 < this.f5173b; i2++) {
                if (i2 > 0) {
                    int i3 = i2 - 1;
                    if (this.f5186e.compare(copyOf[i3], copyOf[i2]) == 0) {
                        String valueOf = String.valueOf(copyOf[i3]);
                        String valueOf2 = String.valueOf(copyOf[i2]);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
                        sb.append("keys required to be distinct but compared as equal: ");
                        sb.append(valueOf);
                        sb.append(" and ");
                        sb.append(valueOf2);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                Object obj3 = this.f5184c[i2];
                obj3.getClass();
                int binarySearch = Arrays.binarySearch(copyOf, obj3, this.f5186e);
                Object obj4 = this.f5185d[i2];
                obj4.getClass();
                objArr[binarySearch] = obj4;
            }
            return new avs(new awx(avg.m4519j(copyOf), this.f5186e), avg.m4519j(objArr));
        }
        return avs.m4482l(this.f5186e);
    }
}
