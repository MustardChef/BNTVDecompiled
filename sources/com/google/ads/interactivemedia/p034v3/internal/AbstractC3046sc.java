package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.sc */
/* loaded from: classes2.dex */
public abstract class AbstractC3046sc extends AbstractC3037ru {

    /* renamed from: a */
    private final HashMap f8814a = new HashMap();

    /* renamed from: b */
    private Handler f8815b;

    /* renamed from: c */
    private InterfaceC2659du f8816c;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: B */
    public void mo1152B() {
        for (C3045sb c3045sb : this.f8814a.values()) {
            c3045sb.f8811a.mo1101A(c3045sb.f8812b);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: D */
    protected void mo1151D() {
        for (C3045sb c3045sb : this.f8814a.values()) {
            c3045sb.f8811a.mo1100C(c3045sb.f8812b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public int mo1138b(Object obj, int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public C3067sx mo1110c(Object obj, C3067sx c3067sx) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final void m1164d(Object obj) {
        C3045sb c3045sb = (C3045sb) this.f8814a.get(obj);
        C2616ce.m2689d(c3045sb);
        c3045sb.f8811a.mo1101A(c3045sb.f8812b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public final void m1163e(Object obj) {
        C3045sb c3045sb = (C3045sb) this.f8814a.get(obj);
        C2616ce.m2689d(c3045sb);
        c3045sb.f8811a.mo1100C(c3045sb.f8812b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public final void m1162f(final Object obj, InterfaceC3069sz interfaceC3069sz) {
        C2616ce.m2687f(!this.f8814a.containsKey(obj));
        InterfaceC3068sy interfaceC3068sy = new InterfaceC3068sy() { // from class: com.google.ads.interactivemedia.v3.internal.rz
            @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3068sy
            /* renamed from: a */
            public final void mo1102a(InterfaceC3069sz interfaceC3069sz2, AbstractC2586bb abstractC2586bb) {
                AbstractC3046sc.this.mo1109i(obj, abstractC2586bb);
            }
        };
        C3044sa c3044sa = new C3044sa(this, obj);
        this.f8814a.put(obj, new C3045sb(interfaceC3069sz, interfaceC3068sy, c3044sa));
        Handler handler = this.f8815b;
        C2616ce.m2689d(handler);
        interfaceC3069sz.mo1092z(handler, c3044sa);
        Handler handler2 = this.f8815b;
        C2616ce.m2689d(handler2);
        interfaceC3069sz.mo1093y(handler2, c3044sa);
        interfaceC3069sz.mo1099E(interfaceC3068sy, this.f8816c);
        if (m1186J()) {
            return;
        }
        interfaceC3069sz.mo1101A(interfaceC3068sy);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public final void m1161g(Object obj) {
        C3045sb c3045sb = (C3045sb) this.f8814a.remove(obj);
        C2616ce.m2689d(c3045sb);
        c3045sb.f8811a.mo1098G(c3045sb.f8812b);
        c3045sb.f8811a.mo1096I(c3045sb.f8813c);
        c3045sb.f8811a.mo1097H(c3045sb.f8813c);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: h */
    public void mo1008h() throws IOException {
        for (C3045sb c3045sb : this.f8814a.values()) {
            c3045sb.f8811a.mo1008h();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public abstract void mo1109i(Object obj, AbstractC2586bb abstractC2586bb);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: n */
    public void mo1007n(InterfaceC2659du interfaceC2659du) {
        this.f8816c = interfaceC2659du;
        this.f8815b = C2628cq.m2508z();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: p */
    public void mo1005p() {
        for (C3045sb c3045sb : this.f8814a.values()) {
            c3045sb.f8811a.mo1098G(c3045sb.f8812b);
            c3045sb.f8811a.mo1096I(c3045sb.f8813c);
            c3045sb.f8811a.mo1097H(c3045sb.f8813c);
        }
        this.f8814a.clear();
    }
}
