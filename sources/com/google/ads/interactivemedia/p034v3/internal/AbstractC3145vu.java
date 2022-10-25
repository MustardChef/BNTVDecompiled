package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Pair;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.vu */
/* loaded from: classes2.dex */
public abstract class AbstractC3145vu {

    /* renamed from: a */
    private InterfaceC3153wb f9242a;

    public AbstractC3145vu() {
    }

    public AbstractC3145vu(byte[] bArr) {
        this();
    }

    /* renamed from: f */
    public void mo788f() {
        throw null;
    }

    /* renamed from: g */
    protected abstract Pair mo787g(C3144vt c3144vt, int[][][] iArr, int[] iArr2) throws C2685et;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public final InterfaceC3153wb m786h() {
        InterfaceC3153wb interfaceC3153wb = this.f9242a;
        C2616ce.m2689d(interfaceC3153wb);
        return interfaceC3153wb;
    }

    /* renamed from: i */
    public final C3146vv m785i(InterfaceC2738gs[] interfaceC2738gsArr, C2588bd c2588bd, C3067sx c3067sx, AbstractC2586bb abstractC2586bb) throws C2685et {
        int[] iArr;
        int[] iArr2 = new int[3];
        C2587bc[][] c2587bcArr = new C2587bc[3];
        int[][][] iArr3 = new int[3][];
        int i = 0;
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = c2588bd.f5440b;
            c2587bcArr[i2] = new C2587bc[i3];
            iArr3[i2] = new int[i3];
        }
        int i4 = 2;
        int[] iArr4 = new int[2];
        for (int i5 = 0; i5 < 2; i5++) {
            iArr4[i5] = interfaceC2738gsArr[i5].mo1221e();
        }
        int i6 = 0;
        while (i6 < c2588bd.f5440b) {
            C2587bc m4121b = c2588bd.m4121b(i6);
            int m4976a = C2554an.m4976a(m4121b.m4193b(i).f8372l);
            int i7 = 0;
            int i8 = 2;
            int i9 = 0;
            boolean z = true;
            while (i7 < i4) {
                InterfaceC2738gs interfaceC2738gs = interfaceC2738gsArr[i7];
                int i10 = 0;
                while (i < m4121b.f5406a) {
                    i10 = Math.max(i10, C2742gw.m2166b(interfaceC2738gs.mo845O(m4121b.m4193b(i))));
                    i++;
                }
                boolean z2 = iArr2[i7] == 0;
                if (i10 > i9) {
                    z = z2;
                    i9 = i10;
                    i8 = i7;
                } else if (i10 == i9 && m4976a == 5 && !z && z2) {
                    i9 = i10;
                    i8 = i7;
                    z = true;
                }
                i7++;
                i4 = 2;
                i = 0;
            }
            if (i8 == i4) {
                iArr = new int[m4121b.f5406a];
            } else {
                InterfaceC2738gs interfaceC2738gs2 = interfaceC2738gsArr[i8];
                int[] iArr5 = new int[m4121b.f5406a];
                for (int i11 = 0; i11 < m4121b.f5406a; i11++) {
                    iArr5[i11] = interfaceC2738gs2.mo845O(m4121b.m4193b(i11));
                }
                iArr = iArr5;
            }
            int i12 = iArr2[i8];
            c2587bcArr[i8][i12] = m4121b;
            iArr3[i8][i12] = iArr;
            iArr2[i8] = i12 + 1;
            i6++;
            i4 = 2;
            i = 0;
        }
        int i13 = 2;
        C2588bd[] c2588bdArr = new C2588bd[2];
        int[] iArr6 = new int[2];
        int i14 = 0;
        while (i14 < i13) {
            int i15 = iArr2[i14];
            c2588bdArr[i14] = new C2588bd((C2587bc[]) C2628cq.m2549ag(c2587bcArr[i14], i15));
            iArr3[i14] = (int[][]) C2628cq.m2549ag(iArr3[i14], i15);
            interfaceC2738gsArr[i14].mo667K();
            iArr6[i14] = interfaceC2738gsArr[i14].mo2170b();
            i14++;
            i13 = 2;
        }
        C3144vt c3144vt = new C3144vt(iArr6, c2588bdArr, iArr3, new C2588bd((C2587bc[]) C2628cq.m2549ag(c2587bcArr[i13], iArr2[i13])));
        Pair mo787g = mo787g(c3144vt, iArr3, iArr4);
        InterfaceC2589be[] interfaceC2589beArr = (InterfaceC2589be[]) mo787g.second;
        avm avmVar = new avm(null);
        for (int i16 = 0; i16 < c3144vt.m793a(); i16++) {
            C2588bd m790d = c3144vt.m790d(i16);
            InterfaceC2589be interfaceC2589be = interfaceC2589beArr[i16];
            for (int i17 = 0; i17 < m790d.f5440b; i17++) {
                C2587bc m4121b2 = m790d.m4121b(i17);
                int i18 = m4121b2.f5406a;
                int[] iArr7 = new int[i18];
                boolean[] zArr = new boolean[i18];
                for (int i19 = 0; i19 < m4121b2.f5406a; i19++) {
                    iArr7[i19] = c3144vt.m791c(i16, i17, i19);
                    zArr[i19] = (interfaceC2589be == null || interfaceC2589be.mo834f() != m4121b2 || interfaceC2589be.mo838b(i19) == -1) ? false : true;
                }
                avmVar.m4498f(new C2595bk(m4121b2, iArr7, c3144vt.m792b(i16), zArr));
            }
        }
        C2588bd m789e = c3144vt.m789e();
        for (int i20 = 0; i20 < m789e.f5440b; i20++) {
            C2587bc m4121b3 = m789e.m4121b(i20);
            int[] iArr8 = new int[m4121b3.f5406a];
            Arrays.fill(iArr8, 0);
            avmVar.m4498f(new C2595bk(m4121b3, iArr8, C2554an.m4976a(m4121b3.m4193b(0).f8372l), new boolean[m4121b3.f5406a]));
        }
        return new C3146vv((C2739gt[]) mo787g.first, (InterfaceC3142vr[]) mo787g.second, new C2596bl(avmVar.m4499e()), c3144vt);
    }

    /* renamed from: j */
    public final void m784j(InterfaceC3153wb interfaceC3153wb) {
        this.f9242a = interfaceC3153wb;
    }
}
