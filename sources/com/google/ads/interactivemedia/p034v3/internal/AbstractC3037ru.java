package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ru */
/* loaded from: classes2.dex */
public abstract class AbstractC3037ru implements InterfaceC3069sz {

    /* renamed from: a */
    private final ArrayList f8779a = new ArrayList(1);

    /* renamed from: b */
    private final HashSet f8780b = new HashSet(1);

    /* renamed from: c */
    private final C3076tf f8781c = new C3076tf();

    /* renamed from: d */
    private final C2915ng f8782d = new C2915ng();

    /* renamed from: e */
    private Looper f8783e;

    /* renamed from: f */
    private AbstractC2586bb f8784f;

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: A */
    public final void mo1101A(InterfaceC3068sy interfaceC3068sy) {
        boolean isEmpty = this.f8780b.isEmpty();
        this.f8780b.remove(interfaceC3068sy);
        if ((!isEmpty) && this.f8780b.isEmpty()) {
            mo1152B();
        }
    }

    /* renamed from: B */
    protected void mo1152B() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: C */
    public final void mo1100C(InterfaceC3068sy interfaceC3068sy) {
        C2616ce.m2689d(this.f8783e);
        boolean isEmpty = this.f8780b.isEmpty();
        this.f8780b.add(interfaceC3068sy);
        if (isEmpty) {
            mo1151D();
        }
    }

    /* renamed from: D */
    protected void mo1151D() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: E */
    public final void mo1099E(InterfaceC3068sy interfaceC3068sy, InterfaceC2659du interfaceC2659du) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.f8783e;
        boolean z = true;
        if (looper != null && looper != myLooper) {
            z = false;
        }
        C2616ce.m2687f(z);
        AbstractC2586bb abstractC2586bb = this.f8784f;
        this.f8779a.add(interfaceC3068sy);
        if (this.f8783e == null) {
            this.f8783e = myLooper;
            this.f8780b.add(interfaceC3068sy);
            mo1007n(interfaceC2659du);
        } else if (abstractC2586bb != null) {
            mo1100C(interfaceC3068sy);
            interfaceC3068sy.mo1102a(this, abstractC2586bb);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: F */
    public final void m1187F(AbstractC2586bb abstractC2586bb) {
        this.f8784f = abstractC2586bb;
        ArrayList arrayList = this.f8779a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((InterfaceC3068sy) arrayList.get(i)).mo1102a(this, abstractC2586bb);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: G */
    public final void mo1098G(InterfaceC3068sy interfaceC3068sy) {
        this.f8779a.remove(interfaceC3068sy);
        if (this.f8779a.isEmpty()) {
            this.f8783e = null;
            this.f8784f = null;
            this.f8780b.clear();
            mo1005p();
            return;
        }
        mo1101A(interfaceC3068sy);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: H */
    public final void mo1097H(InterfaceC2916nh interfaceC2916nh) {
        this.f8782d.m1589h(interfaceC2916nh);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: I */
    public final void mo1096I(InterfaceC3077tg interfaceC3077tg) {
        this.f8781c.m1079l(interfaceC3077tg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: J */
    public final boolean m1186J() {
        return !this.f8780b.isEmpty();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: K */
    public /* synthetic */ boolean mo1095K() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: L */
    public final C3076tf m1185L(int i, C3067sx c3067sx) {
        return this.f8781c.m1090a(i, c3067sx, 0L);
    }

    /* renamed from: n */
    protected abstract void mo1007n(InterfaceC2659du interfaceC2659du);

    /* renamed from: p */
    protected abstract void mo1005p();

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: t */
    public /* synthetic */ AbstractC2586bb mo1094t() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u */
    public final C2915ng m1184u(C3067sx c3067sx) {
        return this.f8782d.m1596a(0, c3067sx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v */
    public final C2915ng m1183v(int i, C3067sx c3067sx) {
        return this.f8782d.m1596a(i, c3067sx);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w */
    public final C3076tf m1182w(C3067sx c3067sx) {
        return this.f8781c.m1090a(0, c3067sx, 0L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x */
    public final C3076tf m1181x(C3067sx c3067sx, long j) {
        return this.f8781c.m1090a(0, c3067sx, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: y */
    public final void mo1093y(Handler handler, InterfaceC2916nh interfaceC2916nh) {
        C2616ce.m2689d(handler);
        C2616ce.m2689d(interfaceC2916nh);
        this.f8782d.m1595b(handler, interfaceC2916nh);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: z */
    public final void mo1092z(Handler handler, InterfaceC3077tg interfaceC3077tg) {
        C2616ce.m2689d(handler);
        C2616ce.m2689d(interfaceC3077tg);
        this.f8781c.m1089b(handler, interfaceC3077tg);
    }
}
