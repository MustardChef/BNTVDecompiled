package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bnk */
/* loaded from: classes2.dex */
public final class bnk {

    /* renamed from: a */
    static final Charset f6264a = Charset.forName(C3282C.ASCII_NAME);

    /* renamed from: b */
    static final Charset f6265b = Charset.forName("UTF-8");

    /* renamed from: c */
    public static final byte[] f6266c;

    /* renamed from: d */
    public static final ByteBuffer f6267d;

    static {
        Charset.forName(C3282C.ISO88591_NAME);
        byte[] bArr = new byte[0];
        f6266c = bArr;
        f6267d = ByteBuffer.wrap(bArr);
        int i = blw.f6044e;
        blw.m3456H(bArr, 0, 0, false);
    }

    /* renamed from: a */
    public static int m3268a(boolean z) {
        return z ? 1231 : 1237;
    }

    /* renamed from: b */
    public static int m3267b(byte[] bArr) {
        int length = bArr.length;
        int m3265d = m3265d(length, bArr, 0, length);
        if (m3265d == 0) {
            return 1;
        }
        return m3265d;
    }

    /* renamed from: c */
    public static int m3266c(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static int m3265d(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static Object m3264e(Object obj, Object obj2) {
        return ((boj) obj).mo3173bi().mo3180aM((boj) obj2).mo3178aS();
    }

    /* renamed from: f */
    public static String m3263f(byte[] bArr) {
        return new String(bArr, f6265b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static boolean m3262g(boj bojVar) {
        if (bojVar instanceof blc) {
            blc blcVar = (blc) bojVar;
            throw null;
        }
        return false;
    }

    /* renamed from: h */
    public static boolean m3261h(byte[] bArr) {
        return bpy.m2863i(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public static void m3260i(Object obj) {
        Objects.requireNonNull(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: j */
    public static void m3259j(Object obj, String str) {
        Objects.requireNonNull(obj, str);
    }
}
