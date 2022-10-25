package com.google.ads.interactivemedia.p034v3.internal;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bcj */
/* loaded from: classes2.dex */
final class bcj implements bfd {

    /* renamed from: a */
    private final String f5411a;

    /* renamed from: b */
    private final int f5412b;

    /* renamed from: c */
    private bdg f5413c;

    /* renamed from: d */
    private bcy f5414d;

    /* renamed from: e */
    private int f5415e;

    /* renamed from: f */
    private bdk f5416f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bcj(bed bedVar) throws GeneralSecurityException {
        String m3934d = bedVar.m3934d();
        this.f5411a = m3934d;
        if (m3934d.equals(bag.f5375b)) {
            try {
                bdh m4067c = bdh.m4067c(bedVar.m3935c(), bmr.m3341a());
                this.f5413c = (bdg) bae.m4240c(bedVar);
                this.f5412b = m4067c.m4069a();
            } catch (bnm e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        } else if (m3934d.equals(bag.f5374a)) {
            try {
                bcz m4128b = bcz.m4128b(bedVar.m3935c(), bmr.m3341a());
                this.f5414d = (bcy) bae.m4240c(bedVar);
                this.f5415e = m4128b.m4127c().m4110a();
                this.f5412b = this.f5415e + m4128b.m4126d().m3965a();
            } catch (bnm e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        } else if (m3934d.equals(bbu.f5402a)) {
            try {
                bdl m4043c = bdl.m4043c(bedVar.m3935c(), bmr.m3341a());
                this.f5416f = (bdk) bae.m4240c(bedVar);
                this.f5412b = m4043c.m4045a();
            } catch (bnm e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        } else {
            String valueOf = String.valueOf(m3934d);
            throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bfd
    /* renamed from: a */
    public final int mo3773a() {
        return this.f5412b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bfd
    /* renamed from: b */
    public final bck mo3772b(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != this.f5412b) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.f5411a.equals(bag.f5375b)) {
            bep m4070g = bdg.m4070g();
            m4070g.m3306aW(this.f5413c);
            m4070g.m3848X(bls.m3503u(bArr, 0, this.f5412b));
            return new bck((azb) bae.m4237f(this.f5411a, (bdg) m4070g.mo3179aR(), azb.class));
        } else if (this.f5411a.equals(bag.f5374a)) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.f5415e);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.f5415e, this.f5412b);
            bep m4111k = bda.m4111k();
            m4111k.m3306aW(this.f5414d.m4135d());
            m4111k.m3836ai(bls.m3504t(copyOfRange));
            bep m3966k = bdx.m3966k();
            m3966k.m3306aW(this.f5414d.m4134e());
            m3966k.m3801w(bls.m3504t(copyOfRange2));
            bep m4130j = bcy.m4130j();
            m4130j.m3829ap(this.f5414d.m4138a());
            m4130j.m3831an((bda) m4111k.mo3179aR());
            m4130j.m3830ao((bdx) m3966k.mo3179aR());
            return new bck((azb) bae.m4237f(this.f5411a, (bcy) m4130j.mo3179aR(), azb.class));
        } else if (this.f5411a.equals(bbu.f5402a)) {
            bep m4046g = bdk.m4046g();
            m4046g.m3306aW(this.f5416f);
            m4046g.m3854R(bls.m3503u(bArr, 0, this.f5412b));
            return new bck((aze) bae.m4237f(this.f5411a, (bdk) m4046g.mo3179aR(), aze.class));
        } else {
            throw new GeneralSecurityException("unknown DEM key type");
        }
    }
}
