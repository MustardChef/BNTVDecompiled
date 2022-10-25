package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.exoplayer2.C3282C;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vp */
/* loaded from: classes2.dex */
public final class C3140vp extends AbstractC3145vu {

    /* renamed from: a */
    public static final /* synthetic */ int f9229a = 0;

    /* renamed from: b */
    private static final int[] f9230b = new int[0];

    /* renamed from: c */
    private static final awp f9231c = awp.m4451b(C3132vh.f9172a);

    /* renamed from: d */
    private static final awp f9232d = awp.m4451b(C3132vh.f9174c);

    /* renamed from: e */
    private final AtomicReference f9233e;

    /* renamed from: f */
    private final C3129ve f9234f;

    @Deprecated
    public C3140vp() {
        C3135vk c3135vk = C3135vk.f9192z;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static int m813a(C2962p c2962p, String str, boolean z) {
        if (TextUtils.isEmpty(str) || !str.equals(c2962p.f8363c)) {
            String m810d = m810d(str);
            String m810d2 = m810d(c2962p.f8363c);
            if (m810d2 == null || m810d == null) {
                return (z && m810d2 == null) ? 1 : 0;
            } else if (m810d2.startsWith(m810d) || m810d.startsWith(m810d2)) {
                return 3;
            } else {
                return C2628cq.m2546aj(m810d2, "-")[0].equals(C2628cq.m2546aj(m810d, "-")[0]) ? 2 : 0;
            }
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public static String m810d(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C3282C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public static boolean m809e(int i, boolean z) {
        int m2166b = C2742gw.m2166b(i);
        return m2166b == 4 || (z && m2166b == 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0054  */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List m808k(com.google.ads.interactivemedia.p034v3.internal.C2587bc r12, int r13, int r14, boolean r15) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r12.f5406a
            r0.<init>(r1)
            r1 = 0
            r2 = 0
        L9:
            int r3 = r12.f5406a
            if (r2 >= r3) goto L17
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.add(r3)
            int r2 = r2 + 1
            goto L9
        L17:
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r13 == r2) goto La5
            if (r14 == r2) goto La5
            r3 = 0
            r4 = 2147483647(0x7fffffff, float:NaN)
        L22:
            int r5 = r12.f5406a
            if (r3 >= r5) goto L7f
            com.google.ads.interactivemedia.v3.internal.p r5 = r12.m4193b(r3)
            int r6 = r5.f8377q
            if (r6 <= 0) goto L7c
            int r7 = r5.f8378r
            if (r7 <= 0) goto L7c
            if (r15 == 0) goto L42
            r8 = 1
            if (r6 > r7) goto L39
            r9 = 0
            goto L3a
        L39:
            r9 = 1
        L3a:
            if (r13 > r14) goto L3d
            r8 = 0
        L3d:
            if (r9 == r8) goto L42
            r8 = r13
            r9 = r14
            goto L44
        L42:
            r9 = r13
            r8 = r14
        L44:
            int r10 = r6 * r8
            int r11 = r7 * r9
            if (r10 < r11) goto L54
            android.graphics.Point r7 = new android.graphics.Point
            int r6 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.m2532b(r11, r6)
            r7.<init>(r9, r6)
            goto L5e
        L54:
            android.graphics.Point r6 = new android.graphics.Point
            int r7 = com.google.ads.interactivemedia.p034v3.internal.C2628cq.m2532b(r10, r7)
            r6.<init>(r7, r8)
            r7 = r6
        L5e:
            int r6 = r5.f8377q
            int r8 = r5.f8378r
            int r8 = r8 * r6
            int r9 = r7.x
            float r9 = (float) r9
            r10 = 1065017672(0x3f7ae148, float:0.98)
            float r9 = r9 * r10
            int r9 = (int) r9
            if (r6 < r9) goto L7c
            int r5 = r5.f8378r
            int r6 = r7.y
            float r6 = (float) r6
            float r6 = r6 * r10
            int r6 = (int) r6
            if (r5 < r6) goto L7c
            if (r8 >= r4) goto L7c
            r4 = r8
        L7c:
            int r3 = r3 + 1
            goto L22
        L7f:
            if (r4 == r2) goto La5
            int r13 = r0.size()
            r14 = -1
            int r13 = r13 + r14
        L87:
            if (r13 < 0) goto La5
            java.lang.Object r15 = r0.get(r13)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            com.google.ads.interactivemedia.v3.internal.p r15 = r12.m4193b(r15)
            int r15 = r15.m1427a()
            if (r15 == r14) goto L9f
            if (r15 <= r4) goto La2
        L9f:
            r0.remove(r13)
        La2:
            int r13 = r13 + (-1)
            goto L87
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3140vp.m808k(com.google.ads.interactivemedia.v3.internal.bc, int, int, boolean):java.util.List");
    }

    /* renamed from: l */
    private static boolean m807l(C2962p c2962p, String str, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8;
        int i9;
        if ((c2962p.f8365e & 16384) == 0 && m809e(i, false) && (i & i2) != 0 && ((str == null || C2628cq.m2563T(c2962p.f8372l, str)) && (((i7 = c2962p.f8377q) == -1 || (i7 >= 0 && i7 <= i3)) && ((i8 = c2962p.f8378r) == -1 || (i8 >= 0 && i8 <= i4))))) {
            float f = c2962p.f8379s;
            if ((f == -1.0f || (f >= 0.0f && f <= i5)) && (i9 = c2962p.f8368h) != -1 && i9 >= 0 && i9 <= i6) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3145vu
    /* renamed from: f */
    public final void mo788f() {
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013b A[LOOP:1: B:13:0x003d->B:51:0x013b, LOOP_END] */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3145vu
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final android.util.Pair mo787g(com.google.ads.interactivemedia.p034v3.internal.C3144vt r34, int[][][] r35, int[] r36) throws com.google.ads.interactivemedia.p034v3.internal.C2685et {
        /*
            Method dump skipped, instructions count: 1401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3140vp.mo787g(com.google.ads.interactivemedia.v3.internal.vt, int[][][], int[]):android.util.Pair");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3140vp(Context context) {
        super(null);
        C3129ve c3129ve = new C3129ve();
        C3135vk m831a = C3135vk.m831a(context);
        this.f9234f = c3129ve;
        this.f9233e = new AtomicReference(m831a);
    }
}
