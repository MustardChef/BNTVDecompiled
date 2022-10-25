package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.sj */
/* loaded from: classes2.dex */
public final class C3053sj extends AbstractC3046sc {

    /* renamed from: a */
    private static final C2543ae f8835a;

    /* renamed from: b */
    private final List f8836b;

    /* renamed from: c */
    private final Set f8837c;

    /* renamed from: d */
    private Handler f8838d;

    /* renamed from: e */
    private final List f8839e;

    /* renamed from: f */
    private final IdentityHashMap f8840f;

    /* renamed from: g */
    private final Map f8841g;

    /* renamed from: h */
    private final Set f8842h;

    /* renamed from: i */
    private boolean f8843i;

    /* renamed from: j */
    private Set f8844j;

    /* renamed from: k */
    private C3101ud f8845k;

    static {
        C3043s c3043s = new C3043s();
        c3043s.m1173e(Uri.EMPTY);
        f8835a = c3043s.m1177a();
    }

    public C3053sj(C3101ud c3101ud, InterfaceC3069sz... interfaceC3069szArr) {
        this.f8845k = c3101ud.m931c() > 0 ? c3101ud.m928f() : c3101ud;
        this.f8840f = new IdentityHashMap();
        this.f8841g = new HashMap();
        this.f8836b = new ArrayList();
        this.f8839e = new ArrayList();
        this.f8844j = new HashSet();
        this.f8837c = new HashSet();
        this.f8842h = new HashSet();
        m1133r(Arrays.asList(interfaceC3069szArr));
    }

    /* renamed from: N */
    private final Handler m1149N() {
        Handler handler = this.f8838d;
        C2616ce.m2689d(handler);
        return handler;
    }

    /* renamed from: O */
    private final void m1148O(int i, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C3051sh c3051sh = (C3051sh) it.next();
            int i2 = i + 1;
            if (i > 0) {
                C3051sh c3051sh2 = (C3051sh) this.f8839e.get(i - 1);
                c3051sh.m1153a(i, c3051sh2.f8830e + c3051sh2.f8826a.m1108j().mo923c());
            } else {
                c3051sh.m1153a(i, 0);
            }
            m1147P(i, 1, c3051sh.f8826a.m1108j().mo923c());
            this.f8839e.add(i, c3051sh);
            this.f8841g.put(c3051sh.f8827b, c3051sh);
            m1162f(c3051sh, c3051sh.f8826a);
            if (!m1186J() || !this.f8840f.isEmpty()) {
                m1164d(c3051sh);
            } else {
                this.f8842h.add(c3051sh);
            }
            i = i2;
        }
    }

    /* renamed from: P */
    private final void m1147P(int i, int i2, int i3) {
        while (i < this.f8839e.size()) {
            C3051sh c3051sh = (C3051sh) this.f8839e.get(i);
            c3051sh.f8829d += i2;
            c3051sh.f8830e += i3;
            i++;
        }
    }

    /* renamed from: Q */
    private final void m1146Q() {
        Iterator it = this.f8842h.iterator();
        while (it.hasNext()) {
            C3051sh c3051sh = (C3051sh) it.next();
            if (c3051sh.f8828c.isEmpty()) {
                m1164d(c3051sh);
                it.remove();
            }
        }
    }

    /* renamed from: R */
    private final synchronized void m1145R(Set set) {
        Iterator it = set.iterator();
        if (it.hasNext()) {
            C3161wj c3161wj = (C3161wj) it.next();
            throw null;
        }
        this.f8837c.removeAll(set);
    }

    /* renamed from: S */
    private final void m1144S(C3051sh c3051sh) {
        if (c3051sh.f8831f && c3051sh.f8828c.isEmpty()) {
            this.f8842h.remove(c3051sh);
            m1161g(c3051sh);
        }
    }

    /* renamed from: T */
    private final void m1143T() {
        m1139X(null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc
    /* renamed from: U */
    public final void mo1109i(C3051sh c3051sh, AbstractC2586bb abstractC2586bb) {
        int mo923c;
        if (c3051sh.f8829d + 1 < this.f8839e.size() && (mo923c = abstractC2586bb.mo923c() - (((C3051sh) this.f8839e.get(c3051sh.f8829d + 1)).f8830e - c3051sh.f8830e)) != 0) {
            m1147P(c3051sh.f8829d + 1, 0, mo923c);
        }
        m1143T();
    }

    /* renamed from: V */
    private final void m1141V() {
        this.f8843i = false;
        Set set = this.f8844j;
        this.f8844j = new HashSet();
        m1187F(new C3049sf(this.f8839e, this.f8845k));
        m1149N().obtainMessage(5, set).sendToTarget();
    }

    /* renamed from: W */
    private final void m1140W(int i, Collection collection) {
        C2616ce.m2687f(true);
        Handler handler = this.f8838d;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C2616ce.m2689d((InterfaceC3069sz) it.next());
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(new C3051sh((InterfaceC3069sz) it2.next()));
        }
        this.f8836b.addAll(i, arrayList);
        if (handler == null || collection.isEmpty()) {
            return;
        }
        handler.obtainMessage(0, new C3052si(i, arrayList, null, null, null)).sendToTarget();
    }

    /* renamed from: X */
    private final void m1139X(C3161wj c3161wj) {
        if (this.f8843i) {
            return;
        }
        m1149N().obtainMessage(4).sendToTarget();
        this.f8843i = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x00d5 A[LOOP:1: B:78:0x00d3->B:79:0x00d5, LOOP_END] */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void m1132s(com.google.ads.interactivemedia.p034v3.internal.C3053sj r8, android.os.Message r9) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.C3053sj.m1132s(com.google.ads.interactivemedia.v3.internal.sj, android.os.Message):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc, com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: B */
    public final void mo1152B() {
        super.mo1152B();
        this.f8842h.clear();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc, com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: D */
    protected final void mo1151D() {
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: K */
    public final boolean mo1095K() {
        return false;
    }

    /* renamed from: M */
    public final synchronized void m1150M(int i) {
        m1136k(i);
        int i2 = i + 1;
        C2616ce.m2687f(true);
        Handler handler = this.f8838d;
        C2628cq.m2565R(this.f8836b, i, i2);
        if (handler != null) {
            handler.obtainMessage(1, new C3052si(i, Integer.valueOf(i2), null, null, null)).sendToTarget();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: a */
    public final C2543ae mo1011a() {
        return f8835a;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ int mo1138b(Object obj, int i) {
        return i + ((C3051sh) obj).f8830e;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc
    /* renamed from: c */
    public final /* bridge */ /* synthetic */ C3067sx mo1110c(Object obj, C3067sx c3067sx) {
        int i = 0;
        while (true) {
            C3051sh c3051sh = (C3051sh) obj;
            if (i >= c3051sh.f8828c.size()) {
                return null;
            }
            if (((C3067sx) c3051sh.f8828c.get(i)).f4118d == c3067sx.f4118d) {
                return c3067sx.m1103c(Pair.create(c3051sh.f8827b, c3067sx.f4115a));
            }
            i++;
        }
    }

    /* renamed from: k */
    public final synchronized InterfaceC3069sz m1136k(int i) {
        return ((C3051sh) this.f8836b.get(i)).f8826a;
    }

    /* renamed from: l */
    public final synchronized void m1135l(InterfaceC3069sz interfaceC3069sz) {
        m1134m(this.f8836b.size(), interfaceC3069sz);
    }

    /* renamed from: m */
    public final synchronized void m1134m(int i, InterfaceC3069sz interfaceC3069sz) {
        m1140W(i, Collections.singletonList(interfaceC3069sz));
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc, com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: n */
    public final synchronized void mo1007n(InterfaceC2659du interfaceC2659du) {
        super.mo1007n(interfaceC2659du);
        this.f8838d = new Handler(new Handler.Callback() { // from class: com.google.ads.interactivemedia.v3.internal.se
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                C3053sj.m1132s(C3053sj.this, message);
                return true;
            }
        });
        if (this.f8836b.isEmpty()) {
            m1141V();
            return;
        }
        this.f8845k = this.f8845k.m927g(0, this.f8836b.size());
        m1148O(0, this.f8836b);
        m1143T();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: o */
    public final void mo1006o(InterfaceC3066sw interfaceC3066sw) {
        C3051sh c3051sh = (C3051sh) this.f8840f.remove(interfaceC3066sw);
        C2616ce.m2689d(c3051sh);
        c3051sh.f8826a.mo1006o(interfaceC3066sw);
        c3051sh.f8828c.remove(((C3060sq) interfaceC3066sw).f8854a);
        if (!this.f8840f.isEmpty()) {
            m1146Q();
        }
        m1144S(c3051sh);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3046sc, com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru
    /* renamed from: p */
    public final synchronized void mo1005p() {
        super.mo1005p();
        this.f8839e.clear();
        this.f8842h.clear();
        this.f8841g.clear();
        this.f8845k = this.f8845k.m928f();
        Handler handler = this.f8838d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f8838d = null;
        }
        this.f8843i = false;
        this.f8844j.clear();
        m1145R(this.f8837c);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: q */
    public final InterfaceC3066sw mo1004q(C3067sx c3067sx, C3154wc c3154wc, long j) {
        Object y = C3049sf.m2440y(c3067sx.f4115a);
        C3067sx m1103c = c3067sx.m1103c(C3049sf.m2441x(c3067sx.f4115a));
        C3051sh c3051sh = (C3051sh) this.f8841g.get(y);
        if (c3051sh == null) {
            c3051sh = new C3051sh(new C3050sg(null));
            c3051sh.f8831f = true;
            m1162f(c3051sh, c3051sh.f8826a);
        }
        this.f8842h.add(c3051sh);
        m1163e(c3051sh);
        c3051sh.f8828c.add(m1103c);
        C3060sq mo1004q = c3051sh.f8826a.mo1004q(m1103c, c3154wc, j);
        this.f8840f.put(mo1004q, c3051sh);
        m1146Q();
        return mo1004q;
    }

    /* renamed from: r */
    public final synchronized void m1133r(Collection collection) {
        m1140W(this.f8836b.size(), collection);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.AbstractC3037ru, com.google.ads.interactivemedia.p034v3.internal.InterfaceC3069sz
    /* renamed from: t */
    public final synchronized AbstractC2586bb mo1094t() {
        C3101ud c3101ud;
        if (this.f8845k.m931c() != this.f8836b.size()) {
            c3101ud = this.f8845k.m928f().m927g(0, this.f8836b.size());
        } else {
            c3101ud = this.f8845k;
        }
        return new C3049sf(this.f8836b, c3101ud);
    }
}
