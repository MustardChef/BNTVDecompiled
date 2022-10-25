package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.og */
/* loaded from: classes2.dex */
final class C2942og implements InterfaceC2637cz {

    /* renamed from: a */
    private final InterfaceC2637cz f8240a;

    /* renamed from: b */
    private final byte[] f8241b;

    /* renamed from: c */
    private final byte[] f8242c;

    /* renamed from: d */
    private CipherInputStream f8243d;

    public C2942og(InterfaceC2637cz interfaceC2637cz, byte[] bArr, byte[] bArr2) {
        this.f8240a = interfaceC2637cz;
        this.f8241b = bArr;
        this.f8242c = bArr2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2746h
    /* renamed from: a */
    public final int mo501a(byte[] bArr, int i, int i2) throws IOException {
        C2616ce.m2689d(this.f8243d);
        int read = this.f8243d.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: b */
    public final long mo1127b(C2642dd c2642dd) throws IOException {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                cipher.init(2, new SecretKeySpec(this.f8241b, "AES"), new IvParameterSpec(this.f8242c));
                C2640db c2640db = new C2640db(this.f8240a, c2642dd);
                this.f8243d = new CipherInputStream(c2640db, cipher);
                c2640db.m2502a();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e) {
                throw new RuntimeException(e);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: c */
    public final Uri mo1126c() {
        return this.f8240a.mo1126c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: d */
    public final void mo1125d() throws IOException {
        if (this.f8243d != null) {
            this.f8243d = null;
            this.f8240a.mo1125d();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: e */
    public final Map mo1124e() {
        return this.f8240a.mo1124e();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2637cz
    /* renamed from: f */
    public final void mo1123f(InterfaceC2659du interfaceC2659du) {
        C2616ce.m2689d(interfaceC2659du);
        this.f8240a.mo1123f(interfaceC2659du);
    }
}
