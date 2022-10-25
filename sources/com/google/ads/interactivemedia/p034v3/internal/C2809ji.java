package com.google.ads.interactivemedia.p034v3.internal;

import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ji */
/* loaded from: classes2.dex */
final class C2809ji {

    /* renamed from: a */
    private final AudioTrack f7649a;

    /* renamed from: b */
    private final AudioTimestamp f7650b = new AudioTimestamp();

    /* renamed from: c */
    private long f7651c;

    /* renamed from: d */
    private long f7652d;

    /* renamed from: e */
    private long f7653e;

    public C2809ji(AudioTrack audioTrack) {
        this.f7649a = audioTrack;
    }

    /* renamed from: a */
    public final long m1943a() {
        return this.f7653e;
    }

    /* renamed from: b */
    public final long m1942b() {
        return this.f7650b.nanoTime / 1000;
    }

    /* renamed from: c */
    public final boolean m1941c() {
        boolean timestamp = this.f7649a.getTimestamp(this.f7650b);
        if (timestamp) {
            long j = this.f7650b.framePosition;
            if (this.f7652d > j) {
                this.f7651c++;
            }
            this.f7652d = j;
            this.f7653e = j + (this.f7651c << 32);
        }
        return timestamp;
    }
}
