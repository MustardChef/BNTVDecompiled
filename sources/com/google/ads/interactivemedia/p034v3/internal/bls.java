package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bls */
/* loaded from: classes2.dex */
public abstract class bls implements Iterable, Serializable {

    /* renamed from: a */
    private static final bln f6014a;

    /* renamed from: b */
    public static final bls f6015b = new blq(bnk.f6266c);

    /* renamed from: c */
    private int f6016c = 0;

    static {
        int i = ble.f5993a;
        f6014a = new blr(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public static void m3511A(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder(22);
                sb.append("Index < 0: ");
                sb.append(i);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Index > length: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
    }

    /* renamed from: t */
    public static bls m3504t(byte[] bArr) {
        return m3503u(bArr, 0, bArr.length);
    }

    /* renamed from: u */
    public static bls m3503u(byte[] bArr, int i, int i2) {
        m3506q(i, i + i2, bArr.length);
        return new blq(f6014a.mo3512a(bArr, i, i2));
    }

    /* renamed from: v */
    public static bls m3502v(String str) {
        return new blq(str.getBytes(bnk.f6265b));
    }

    /* renamed from: w */
    public static bls m3501w(InputStream inputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            bls m3503u = i2 == 0 ? null : m3503u(bArr, 0, i2);
            if (m3503u == null) {
                break;
            }
            arrayList.add(m3503u);
            i = Math.min(i + i, 8192);
        }
        int size = arrayList.size();
        return size == 0 ? f6015b : m3507c(arrayList.iterator(), size);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public static bls m3500x(byte[] bArr) {
        return new blq(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y */
    public static bls m3499y(byte[] bArr, int i, int i2) {
        return new blm(bArr, i, i2);
    }

    /* renamed from: B */
    public final boolean m3510B() {
        return mo3054d() == 0;
    }

    /* renamed from: C */
    public final byte[] m3509C() {
        int mo3054d = mo3054d();
        if (mo3054d == 0) {
            return bnk.f6266c;
        }
        byte[] bArr = new byte[mo3054d];
        mo3053e(bArr, 0, 0, mo3054d);
        return bArr;
    }

    @Deprecated
    /* renamed from: D */
    public final void m3508D(byte[] bArr, int i, int i2) {
        m3506q(0, i2, mo3054d());
        m3506q(i, i + i2, bArr.length);
        if (i2 > 0) {
            mo3053e(bArr, 0, i, i2);
        }
    }

    /* renamed from: a */
    public abstract byte mo3057a(int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public abstract byte mo3056b(int i);

    /* renamed from: d */
    public abstract int mo3054d();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public abstract void mo3053e(byte[] bArr, int i, int i2, int i3);

    public abstract boolean equals(Object obj);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public abstract int mo3052f();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public abstract boolean mo3050h();

    public final int hashCode() {
        int i = this.f6016c;
        if (i == 0) {
            int mo3054d = mo3054d();
            i = mo3049i(mo3054d, 0, mo3054d);
            if (i == 0) {
                i = 1;
            }
            this.f6016c = i;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public abstract int mo3049i(int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public abstract int mo3048j(int i, int i2, int i3);

    /* renamed from: k */
    public abstract bls mo3047k(int i, int i2);

    /* renamed from: l */
    public abstract blw mo3046l();

    /* renamed from: m */
    protected abstract String mo3045m(Charset charset);

    /* renamed from: n */
    public abstract ByteBuffer mo3044n();

    /* renamed from: o */
    public abstract boolean mo3043o();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public abstract void mo3042p(bnv bnvVar) throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r */
    public final int m3505r() {
        return this.f6016c;
    }

    @Override // java.lang.Iterable
    /* renamed from: s */
    public blo iterator() {
        return new blk(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(mo3054d());
        objArr[2] = mo3054d() <= 50 ? bqd.m2811B(this) : String.valueOf(bqd.m2811B(mo3047k(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    /* renamed from: z */
    public final String m3498z() {
        return mo3054d() == 0 ? "" : mo3045m(bnk.f6265b);
    }

    /* renamed from: c */
    private static bls m3507c(Iterator it, int i) {
        if (i > 0) {
            if (i == 1) {
                return (bls) it.next();
            }
            int i2 = i >>> 1;
            bls m3507c = m3507c(it, i2);
            bls m3507c2 = m3507c(it, i - i2);
            if (Integer.MAX_VALUE - m3507c.mo3054d() < m3507c2.mo3054d()) {
                int mo3054d = m3507c.mo3054d();
                int mo3054d2 = m3507c2.mo3054d();
                StringBuilder sb = new StringBuilder(53);
                sb.append("ByteString would be too long: ");
                sb.append(mo3054d);
                sb.append("+");
                sb.append(mo3054d2);
                throw new IllegalArgumentException(sb.toString());
            }
            return box.m3059F(m3507c, m3507c2);
        }
        throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public static int m3506q(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) < 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Beginning index: ");
                sb.append(i);
                sb.append(" < 0");
                throw new IndexOutOfBoundsException(sb.toString());
            } else if (i2 < i) {
                StringBuilder sb2 = new StringBuilder(66);
                sb2.append("Beginning index larger than ending index: ");
                sb2.append(i);
                sb2.append(", ");
                sb2.append(i2);
                throw new IndexOutOfBoundsException(sb2.toString());
            } else {
                StringBuilder sb3 = new StringBuilder(37);
                sb3.append("End index: ");
                sb3.append(i2);
                sb3.append(" >= ");
                sb3.append(i3);
                throw new IndexOutOfBoundsException(sb3.toString());
            }
        }
        return i4;
    }
}
