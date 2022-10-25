package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.av */
/* loaded from: classes2.dex */
public final class C2566av {

    /* renamed from: a */
    public final Object f5151a;

    /* renamed from: b */
    public final int f5152b;

    /* renamed from: c */
    public final C2543ae f5153c;

    /* renamed from: d */
    public final Object f5154d;

    /* renamed from: e */
    public final int f5155e;

    /* renamed from: f */
    public final long f5156f;

    /* renamed from: g */
    public final long f5157g;

    /* renamed from: h */
    public final int f5158h;

    /* renamed from: i */
    public final int f5159i;

    public C2566av(Object obj, int i, C2543ae c2543ae, Object obj2, int i2, long j, long j2, int i3, int i4) {
        this.f5151a = obj;
        this.f5152b = i;
        this.f5153c = c2543ae;
        this.f5154d = obj2;
        this.f5155e = i2;
        this.f5156f = j;
        this.f5157g = j2;
        this.f5158h = i3;
        this.f5159i = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            C2566av c2566av = (C2566av) obj;
            if (this.f5152b == c2566av.f5152b && this.f5155e == c2566av.f5155e && this.f5156f == c2566av.f5156f && this.f5157g == c2566av.f5157g && this.f5158h == c2566av.f5158h && this.f5159i == c2566av.f5159i && anx.m4882b(this.f5151a, c2566av.f5151a) && anx.m4882b(this.f5154d, c2566av.f5154d) && anx.m4882b(this.f5153c, c2566av.f5153c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5151a, Integer.valueOf(this.f5152b), this.f5153c, this.f5154d, Integer.valueOf(this.f5155e), Long.valueOf(this.f5156f), Long.valueOf(this.f5157g), Integer.valueOf(this.f5158h), Integer.valueOf(this.f5159i)});
    }
}
