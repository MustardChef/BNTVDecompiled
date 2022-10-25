package com.google.ads.interactivemedia.p034v3.internal;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.jm */
/* loaded from: classes2.dex */
public abstract class AbstractC2813jm implements InterfaceC2791ir {

    /* renamed from: h */
    private boolean f7698h;

    /* renamed from: f */
    private ByteBuffer f7696f = f7617a;

    /* renamed from: g */
    private ByteBuffer f7697g = f7617a;

    /* renamed from: d */
    private C2789ip f7694d = C2789ip.f7612a;

    /* renamed from: e */
    private C2789ip f7695e = C2789ip.f7612a;

    /* renamed from: b */
    protected C2789ip f7692b = C2789ip.f7612a;

    /* renamed from: c */
    protected C2789ip f7693c = C2789ip.f7612a;

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: a */
    public final C2789ip mo1810a(C2789ip c2789ip) throws C2790iq {
        this.f7694d = c2789ip;
        this.f7695e = mo1799i(c2789ip);
        return mo1806g() ? this.f7695e : C2789ip.f7612a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: b */
    public ByteBuffer mo1802b() {
        ByteBuffer byteBuffer = this.f7697g;
        this.f7697g = f7617a;
        return byteBuffer;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: c */
    public final void mo1809c() {
        this.f7697g = f7617a;
        this.f7698h = false;
        this.f7692b = this.f7694d;
        this.f7693c = this.f7695e;
        mo1798k();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: d */
    public final void mo1808d() {
        this.f7698h = true;
        mo1797l();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: f */
    public final void mo1807f() {
        mo1809c();
        this.f7696f = f7617a;
        this.f7694d = C2789ip.f7612a;
        this.f7695e = C2789ip.f7612a;
        this.f7692b = C2789ip.f7612a;
        this.f7693c = C2789ip.f7612a;
        mo1796m();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: g */
    public boolean mo1806g() {
        return this.f7695e != C2789ip.f7612a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2791ir
    /* renamed from: h */
    public boolean mo1800h() {
        return this.f7698h && this.f7697g == f7617a;
    }

    /* renamed from: i */
    protected C2789ip mo1799i(C2789ip c2789ip) throws C2790iq {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public final ByteBuffer m1916j(int i) {
        if (this.f7696f.capacity() < i) {
            this.f7696f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f7696f.clear();
        }
        ByteBuffer byteBuffer = this.f7696f;
        this.f7697g = byteBuffer;
        return byteBuffer;
    }

    /* renamed from: k */
    protected void mo1798k() {
    }

    /* renamed from: l */
    protected void mo1797l() {
    }

    /* renamed from: m */
    protected void mo1796m() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public final boolean m1915n() {
        return this.f7697g.hasRemaining();
    }
}
