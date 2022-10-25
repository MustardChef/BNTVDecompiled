package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.io */
/* loaded from: classes2.dex */
public final class C2788io {

    /* renamed from: a */
    private final int[] f7610a;

    /* renamed from: b */
    private final int f7611b;

    static {
        new C2788io(new int[]{2});
        new C2788io(new int[]{2, 5, 6});
    }

    public C2788io(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.f7610a = copyOf;
        Arrays.sort(copyOf);
        this.f7611b = 8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2788io) {
            C2788io c2788io = (C2788io) obj;
            if (Arrays.equals(this.f7610a, c2788io.f7610a)) {
                int i = c2788io.f7611b;
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.f7610a) * 31) + 8;
    }

    public final String toString() {
        String arrays = Arrays.toString(this.f7610a);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 67);
        sb.append("AudioCapabilities[maxChannelCount=");
        sb.append(8);
        sb.append(", supportedEncodings=");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }
}
