package com.google.ads.interactivemedia.p034v3.internal;

import com.google.android.exoplayer2.C3282C;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.wz */
/* loaded from: classes2.dex */
public final class C3177wz {

    /* renamed from: a */
    private static final Object f9337a = new Object();

    /* renamed from: b */
    private static final Object f9338b = new Object();

    /* renamed from: c */
    private static boolean f9339c = false;

    /* renamed from: d */
    private static long f9340d = 0;

    /* renamed from: e */
    private static final String f9341e = "time.android.com";

    /* JADX WARN: Code restructure failed: missing block: B:90:0x0102, code lost:
        if (r9 > 15) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0108, code lost:
        if (r15 == 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x010a, code lost:
        r13 = ((r13 - r10) + (r15 - r6)) / 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0110, code lost:
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0115, code lost:
        return (r6 + r13) - r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x011d, code lost:
        throw new java.io.IOException("SNTP: Zero transmitTime");
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* bridge */ /* synthetic */ long m699a() {
        /*
            Method dump skipped, instructions count: 334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3177wz.m699a():long");
    }

    /* renamed from: b */
    public static long m698b() {
        long j;
        synchronized (f9338b) {
            j = f9339c ? f9340d : C3282C.TIME_UNSET;
        }
        return j;
    }

    /* renamed from: f */
    public static void m694f(C3167wp c3167wp, InterfaceC3174ww interfaceC3174ww) {
        if (m692h()) {
            interfaceC3174ww.mo705b();
            return;
        }
        if (c3167wp == null) {
            c3167wp = new C3167wp("SntpClient");
        }
        c3167wp.m728b(new C3176wy(null), new C3175wx(interfaceC3174ww), 1);
    }

    /* renamed from: h */
    public static boolean m692h() {
        boolean z;
        synchronized (f9338b) {
            z = f9339c;
        }
        return z;
    }

    /* renamed from: j */
    private static long m690j(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
    }

    /* renamed from: k */
    private static long m689k(byte[] bArr, int i) {
        long m690j = m690j(bArr, i);
        long m690j2 = m690j(bArr, i + 4);
        if (m690j == 0) {
            if (m690j2 == 0) {
                return 0L;
            }
            m690j = 0;
        }
        return ((m690j - 2208988800L) * 1000) + ((m690j2 * 1000) / 4294967296L);
    }
}
