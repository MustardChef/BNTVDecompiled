package com.google.ads.interactivemedia.p034v3.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.box */
/* loaded from: classes2.dex */
public final class box extends bls {

    /* renamed from: a */
    static final int[] f6359a = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, bqk.f6598ce, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private static final long serialVersionUID = 1;

    /* renamed from: c */
    private final int f6360c;

    /* renamed from: d */
    private final bls f6361d;

    /* renamed from: e */
    private final bls f6362e;

    /* renamed from: f */
    private final int f6363f;

    /* renamed from: g */
    private final int f6364g;

    private box(bls blsVar, bls blsVar2) {
        this.f6361d = blsVar;
        this.f6362e = blsVar2;
        int mo3054d = blsVar.mo3054d();
        this.f6363f = mo3054d;
        this.f6360c = mo3054d + blsVar2.mo3054d();
        this.f6364g = Math.max(blsVar.mo3052f(), blsVar2.mo3052f()) + 1;
    }

    /* renamed from: F */
    public static bls m3059F(bls blsVar, bls blsVar2) {
        if (blsVar2.mo3054d() == 0) {
            return blsVar;
        }
        if (blsVar.mo3054d() == 0) {
            return blsVar2;
        }
        int mo3054d = blsVar.mo3054d() + blsVar2.mo3054d();
        if (mo3054d < 128) {
            return m3058G(blsVar, blsVar2);
        }
        if (blsVar instanceof box) {
            box boxVar = (box) blsVar;
            if (boxVar.f6362e.mo3054d() + blsVar2.mo3054d() < 128) {
                return new box(boxVar.f6361d, m3058G(boxVar.f6362e, blsVar2));
            } else if (boxVar.f6361d.mo3052f() > boxVar.f6362e.mo3052f() && boxVar.f6364g > blsVar2.mo3052f()) {
                return new box(boxVar.f6361d, new box(boxVar.f6362e, blsVar2));
            }
        }
        if (mo3054d >= m3055c(Math.max(blsVar.mo3052f(), blsVar2.mo3052f()) + 1)) {
            return new box(blsVar, blsVar2);
        }
        return bov.m3065a(new bov(null), blsVar, blsVar2);
    }

    /* renamed from: G */
    private static bls m3058G(bls blsVar, bls blsVar2) {
        int mo3054d = blsVar.mo3054d();
        int mo3054d2 = blsVar2.mo3054d();
        byte[] bArr = new byte[mo3054d + mo3054d2];
        blsVar.m3508D(bArr, 0, mo3054d);
        blsVar2.m3508D(bArr, mo3054d, mo3054d2);
        return bls.m3500x(bArr);
    }

    /* renamed from: c */
    public static int m3055c(int i) {
        int[] iArr = f6359a;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: a */
    public final byte mo3057a(int i) {
        m3511A(i, this.f6360c);
        return mo3056b(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: b */
    public final byte mo3056b(int i) {
        int i2 = this.f6363f;
        return i < i2 ? this.f6361d.mo3056b(i) : this.f6362e.mo3056b(i - i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: d */
    public final int mo3054d() {
        return this.f6360c;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: e */
    public final void mo3053e(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.f6363f;
        if (i + i3 <= i4) {
            this.f6361d.mo3053e(bArr, i, i2, i3);
        } else if (i >= i4) {
            this.f6362e.mo3053e(bArr, i - i4, i2, i3);
        } else {
            int i5 = i4 - i;
            this.f6361d.mo3053e(bArr, i, i2, i5);
            this.f6362e.mo3053e(bArr, 0, i2 + i5, i3 - i5);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    public final boolean equals(Object obj) {
        boolean mo3513g;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof bls)) {
            return false;
        }
        bls blsVar = (bls) obj;
        if (this.f6360c != blsVar.mo3054d()) {
            return false;
        }
        if (this.f6360c == 0) {
            return true;
        }
        int m3505r = m3505r();
        int m3505r2 = blsVar.m3505r();
        if (m3505r != 0 && m3505r2 != 0 && m3505r != m3505r2) {
            return false;
        }
        bow bowVar = new bow(this);
        blp next = bowVar.next();
        bow bowVar2 = new bow(blsVar);
        blp next2 = bowVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int d = next.mo3054d() - i;
            int d2 = next2.mo3054d() - i2;
            int min = Math.min(d, d2);
            if (i == 0) {
                mo3513g = next.mo3513g(next2, i2, min);
            } else {
                mo3513g = next2.mo3513g(next, i, min);
            }
            if (!mo3513g) {
                return false;
            }
            i3 += min;
            int i4 = this.f6360c;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == d) {
                next = bowVar.next();
                i = 0;
            } else {
                i += min;
            }
            if (min == d2) {
                next2 = bowVar2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: f */
    public final int mo3052f() {
        return this.f6364g;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: h */
    public final boolean mo3050h() {
        return this.f6360c >= m3055c(this.f6364g);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: i */
    public final int mo3049i(int i, int i2, int i3) {
        int i4 = this.f6363f;
        if (i2 + i3 <= i4) {
            return this.f6361d.mo3049i(i, i2, i3);
        }
        if (i2 >= i4) {
            return this.f6362e.mo3049i(i, i2 - i4, i3);
        }
        int i5 = i4 - i2;
        return this.f6362e.mo3049i(this.f6361d.mo3049i(i, i2, i5), 0, i3 - i5);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: j */
    public final int mo3048j(int i, int i2, int i3) {
        int i4 = this.f6363f;
        if (i2 + i3 <= i4) {
            return this.f6361d.mo3048j(i, i2, i3);
        }
        if (i2 >= i4) {
            return this.f6362e.mo3048j(i, i2 - i4, i3);
        }
        int i5 = i4 - i2;
        return this.f6362e.mo3048j(this.f6361d.mo3048j(i, i2, i5), 0, i3 - i5);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: k */
    public final bls mo3047k(int i, int i2) {
        int q = m3506q(i, i2, this.f6360c);
        if (q == 0) {
            return bls.f6015b;
        }
        if (q == this.f6360c) {
            return this;
        }
        int i3 = this.f6363f;
        if (i2 <= i3) {
            return this.f6361d.mo3047k(i, i2);
        }
        if (i >= i3) {
            return this.f6362e.mo3047k(i - i3, i2 - i3);
        }
        bls blsVar = this.f6361d;
        return new box(blsVar.mo3047k(i, blsVar.mo3054d()), this.f6362e.mo3047k(0, i2 - this.f6363f));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: l */
    public final blw mo3046l() {
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        bow bowVar = new bow(this);
        while (bowVar.hasNext()) {
            arrayList.add(bowVar.next().mo3044n());
        }
        int i = blw.f6044e;
        boolean z = false;
        int i2 = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            i2 += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                z |= true;
            } else {
                z = byteBuffer.isDirect() ? z | true : z | true;
            }
        }
        if (z) {
            return new blu(arrayList, i2);
        }
        return new blv(new bnn(arrayList));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: m */
    protected final String mo3045m(Charset charset) {
        return new String(m3509C(), charset);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: n */
    public final ByteBuffer mo3044n() {
        throw null;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: o */
    public final boolean mo3043o() {
        int mo3048j = this.f6361d.mo3048j(0, 0, this.f6363f);
        bls blsVar = this.f6362e;
        return blsVar.mo3048j(mo3048j, 0, blsVar.mo3054d()) == 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: p */
    public final void mo3042p(bnv bnvVar) throws IOException {
        this.f6361d.mo3042p(bnvVar);
        this.f6362e.mo3042p(bnvVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: s */
    public final blo mo3041s() {
        return new bou(this);
    }

    Object writeReplace() {
        return bls.m3500x(m3509C());
    }

    public /* synthetic */ box(bls blsVar, bls blsVar2, byte[] bArr) {
        this(blsVar, blsVar2);
    }
}
