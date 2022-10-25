package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.blq */
/* loaded from: classes2.dex */
public class blq extends blp {
    private static final long serialVersionUID = 1;

    /* renamed from: a */
    protected final byte[] f6013a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public blq(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.f6013a = bArr;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: a */
    public byte mo3057a(int i) {
        return this.f6013a[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: b */
    public byte mo3056b(int i) {
        return this.f6013a[i];
    }

    /* renamed from: c */
    protected int mo3514c() {
        return 0;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: d */
    public int mo3054d() {
        return this.f6013a.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: e */
    public void mo3053e(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f6013a, i, bArr, i2, i3);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof bls) && mo3054d() == ((bls) obj).mo3054d()) {
            if (mo3054d() == 0) {
                return true;
            }
            if (obj instanceof blq) {
                blq blqVar = (blq) obj;
                int m3505r = m3505r();
                int m3505r2 = blqVar.m3505r();
                if (m3505r == 0 || m3505r2 == 0 || m3505r == m3505r2) {
                    return mo3513g(blqVar, 0, mo3054d());
                }
                return false;
            }
            return obj.equals(this);
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.blp
    /* renamed from: g */
    final boolean mo3513g(bls blsVar, int i, int i2) {
        if (i2 > blsVar.mo3054d()) {
            int mo3054d = mo3054d();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(mo3054d);
            throw new IllegalArgumentException(sb.toString());
        }
        int i3 = i + i2;
        if (i3 > blsVar.mo3054d()) {
            int mo3054d2 = blsVar.mo3054d();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(mo3054d2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (blsVar instanceof blq) {
            blq blqVar = (blq) blsVar;
            byte[] bArr = this.f6013a;
            byte[] bArr2 = blqVar.f6013a;
            int mo3514c = mo3514c() + i2;
            int mo3514c2 = mo3514c();
            int mo3514c3 = blqVar.mo3514c() + i;
            while (mo3514c2 < mo3514c) {
                if (bArr[mo3514c2] != bArr2[mo3514c3]) {
                    return false;
                }
                mo3514c2++;
                mo3514c3++;
            }
            return true;
        } else {
            return blsVar.mo3047k(i, i3).equals(mo3047k(0, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: i */
    public final int mo3049i(int i, int i2, int i3) {
        return bnk.m3265d(i, this.f6013a, mo3514c() + i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: j */
    public final int mo3048j(int i, int i2, int i3) {
        int mo3514c = mo3514c() + i2;
        return bpy.m2866f(i, this.f6013a, mo3514c, i3 + mo3514c);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: k */
    public final bls mo3047k(int i, int i2) {
        int q = m3506q(i, i2, mo3054d());
        return q == 0 ? bls.f6015b : new blm(this.f6013a, mo3514c() + i, q);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: l */
    public final blw mo3046l() {
        return blw.m3456H(this.f6013a, mo3514c(), mo3054d(), true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: m */
    protected final String mo3045m(Charset charset) {
        return new String(this.f6013a, mo3514c(), mo3054d(), charset);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: n */
    public final ByteBuffer mo3044n() {
        return ByteBuffer.wrap(this.f6013a, mo3514c(), mo3054d()).asReadOnlyBuffer();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: o */
    public final boolean mo3043o() {
        int mo3514c = mo3514c();
        return bpy.m2862j(this.f6013a, mo3514c, mo3054d() + mo3514c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.ads.interactivemedia.p034v3.internal.bls
    /* renamed from: p */
    public final void mo3042p(bnv bnvVar) throws IOException {
        ((bma) bnvVar).m3415M(this.f6013a, mo3514c(), mo3054d());
    }
}
