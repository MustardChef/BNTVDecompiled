package com.google.ads.interactivemedia.p034v3.internal;

import com.google.ads.interactivemedia.p034v3.internal.bmz;
import com.google.ads.interactivemedia.p034v3.internal.bnd;
import java.io.IOException;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmz */
/* loaded from: classes2.dex */
public class bmz<MessageType extends bnd<MessageType, BuilderType>, BuilderType extends bmz<MessageType, BuilderType>> extends bla<MessageType, BuilderType> {

    /* renamed from: a */
    protected bnd f6249a;

    /* renamed from: b */
    protected boolean f6250b = false;

    /* renamed from: c */
    private final bnd f6251c;

    /* JADX INFO: Access modifiers changed from: protected */
    public bmz(MessageType messagetype) {
        this.f6251c = messagetype;
        this.f6249a = (bnd) messagetype.m3289aE(4);
    }

    /* renamed from: a */
    private static final void m3312a(bnd bndVar, bnd bndVar2) {
        boq.m3120a().m3118c(bndVar).mo3036g(bndVar, bndVar2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bla
    /* renamed from: aL */
    protected final /* synthetic */ bla mo3310aL(blb blbVar) {
        m3306aW((bnd) blbVar);
        return this;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bla
    /* renamed from: aO */
    public final bmz clone() {
        bmz bmzVar = (bmz) this.f6251c.m3289aE(5);
        bmzVar.m3306aW(mo3178aS());
        return bmzVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boi
    /* renamed from: aP */
    public final MessageType mo3179aR() {
        MessageType mo3178aS = mo3178aS();
        if (mo3178aS.mo3170aV()) {
            return mo3178aS;
        }
        throw new bpl();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boi
    /* renamed from: aQ */
    public MessageType mo3178aS() {
        if (this.f6250b) {
            return (MessageType) this.f6249a;
        }
        bnd bndVar = this.f6249a;
        boq.m3120a().m3118c(bndVar).mo3037f(bndVar);
        this.f6250b = true;
        return (MessageType) this.f6249a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bok
    /* renamed from: aT */
    public final /* synthetic */ boj mo3171aT() {
        return this.f6251c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: aU */
    public void mo3302aU() {
        bnd bndVar = (bnd) this.f6249a.m3289aE(4);
        m3312a(bndVar, this.f6249a);
        this.f6249a = bndVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bok
    /* renamed from: aV */
    public final boolean mo3170aV() {
        throw null;
    }

    /* renamed from: aW */
    public final void m3306aW(bnd bndVar) {
        if (this.f6250b) {
            mo3302aU();
            this.f6250b = false;
        }
        m3312a(this.f6249a, bndVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bla
    /* renamed from: aX */
    public final void mo3309aN(byte[] bArr, int i, bmr bmrVar) throws bnm {
        if (this.f6250b) {
            mo3302aU();
            this.f6250b = false;
        }
        try {
            boq.m3120a().m3118c(this.f6249a).mo3034i(this.f6249a, bArr, 0, i, new blf(bmrVar));
        } catch (bnm e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw bnm.m3250i();
        }
    }
}
