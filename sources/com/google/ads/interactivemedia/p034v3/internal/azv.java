package com.google.ads.interactivemedia.p034v3.internal;

import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.azv */
/* loaded from: classes2.dex */
final class azv implements Comparable {

    /* renamed from: a */
    private final byte[] f5337a;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        azv azvVar = (azv) obj;
        int length = this.f5337a.length;
        int length2 = azvVar.f5337a.length;
        if (length != length2) {
            return length - length2;
        }
        int i = 0;
        while (true) {
            byte[] bArr = this.f5337a;
            if (i >= bArr.length) {
                return 0;
            }
            byte b = bArr[i];
            byte b2 = azvVar.f5337a[i];
            if (b != b2) {
                return b - b2;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof azv) {
            return Arrays.equals(this.f5337a, ((azv) obj).f5337a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5337a);
    }

    public final String toString() {
        byte[] bArr = this.f5337a;
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b : bArr) {
            int i = b & 255;
            sb.append("0123456789abcdef".charAt(i >> 4));
            sb.append("0123456789abcdef".charAt(i & 15));
        }
        return sb.toString();
    }
}
