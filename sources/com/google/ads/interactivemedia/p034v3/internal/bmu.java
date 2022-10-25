package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmu */
/* loaded from: classes2.dex */
public final class bmu {

    /* renamed from: b */
    private static final bmu f6179b = new bmu(null);

    /* renamed from: a */
    final bpi f6180a = bpi.m2968c(16);

    /* renamed from: c */
    private boolean f6181c;

    /* renamed from: d */
    private boolean f6182d;

    private bmu() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static int m3337a(bpz bpzVar, int i, Object obj) {
        int m3368u = bma.m3368u(i);
        if (bpzVar == bpz.GROUP) {
            bnk.m3262g((boj) obj);
            m3368u += m3368u;
        }
        bqa bqaVar = bqa.INT;
        int i2 = 4;
        switch (bpzVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                i2 = 8;
                break;
            case 1:
                ((Float) obj).floatValue();
                break;
            case 2:
                i2 = bma.m3364y(((Long) obj).longValue());
                break;
            case 3:
                i2 = bma.m3364y(((Long) obj).longValue());
                break;
            case 4:
                i2 = bma.m3381h(((Integer) obj).intValue());
                break;
            case 5:
                ((Long) obj).longValue();
                i2 = 8;
                break;
            case 6:
                ((Integer) obj).intValue();
                break;
            case 7:
                ((Boolean) obj).booleanValue();
                i2 = 1;
                break;
            case 8:
                if (obj instanceof bls) {
                    i2 = bma.m3386c((bls) obj);
                    break;
                } else {
                    i2 = bma.m3369t((String) obj);
                    break;
                }
            case 9:
                i2 = bma.m3383f((boj) obj);
                break;
            case 10:
                if (obj instanceof bnr) {
                    i2 = bma.m3378k((bnr) obj);
                    break;
                } else {
                    i2 = bma.m3376m((boj) obj);
                    break;
                }
            case 11:
                if (obj instanceof bls) {
                    i2 = bma.m3386c((bls) obj);
                    break;
                } else {
                    i2 = bma.m3401a((byte[]) obj);
                    break;
                }
            case 12:
                i2 = bma.m3366w(((Integer) obj).intValue());
                break;
            case 13:
                if (obj instanceof bnf) {
                    i2 = bma.m3381h(((bnf) obj).getNumber());
                    break;
                } else {
                    i2 = bma.m3381h(((Integer) obj).intValue());
                    break;
                }
            case 14:
                ((Integer) obj).intValue();
                break;
            case 15:
                ((Long) obj).longValue();
                i2 = 8;
                break;
            case 16:
                i2 = bma.m3373p(((Integer) obj).intValue());
                break;
            case 17:
                i2 = bma.m3371r(((Long) obj).longValue());
                break;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return m3368u + i2;
    }

    /* renamed from: b */
    public static int m3336b(bmt bmtVar, Object obj) {
        bpz mo3298c = bmtVar.mo3298c();
        int mo3300a = bmtVar.mo3300a();
        if (bmtVar.mo3296e()) {
            bmtVar.mo3294g();
            int i = 0;
            for (Object obj2 : (List) obj) {
                i += m3337a(mo3298c, mo3300a, obj2);
            }
            return i;
        }
        return m3337a(mo3298c, mo3300a, obj);
    }

    /* renamed from: e */
    public static bmu m3333e() {
        return f6179b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public static void m3323o(bma bmaVar, int i, Object obj) throws IOException {
        if (bpz.GROUP != null) {
            throw null;
        }
        boj bojVar = (boj) obj;
        bnk.m3262g(bojVar);
        bmaVar.m3399ab(i, 3);
        bmaVar.m3421G(bojVar);
        bmaVar.m3399ab(i, 4);
    }

    /* renamed from: p */
    private static Object m3322p(Object obj) {
        if (obj instanceof bon) {
            return ((bon) obj).mo3123c();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length;
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, length);
            return bArr2;
        }
        return obj;
    }

    /* renamed from: q */
    private final void m3321q(Map.Entry entry) {
        boj mo3179aR;
        bmt bmtVar = (bmt) entry.getKey();
        Object value = entry.getValue();
        if (!(value instanceof bnr)) {
            if (bmtVar.mo3296e()) {
                Object m3332f = m3332f(bmtVar);
                if (m3332f == null) {
                    m3332f = new ArrayList();
                }
                for (Object obj : (List) value) {
                    ((List) m3332f).add(m3322p(obj));
                }
                this.f6180a.put(bmtVar, m3332f);
                return;
            } else if (bmtVar.mo3297d() == bqa.MESSAGE) {
                Object m3332f2 = m3332f(bmtVar);
                if (m3332f2 == null) {
                    this.f6180a.put(bmtVar, m3322p(value));
                    return;
                }
                if (m3332f2 instanceof bon) {
                    bon bonVar = (bon) m3332f2;
                    bon bonVar2 = (bon) value;
                    mo3179aR = bmtVar.mo3295f();
                } else {
                    mo3179aR = bmtVar.mo3299b(((boj) m3332f2).mo3173bi(), (boj) value).mo3179aR();
                }
                this.f6180a.put(bmtVar, mo3179aR);
                return;
            } else {
                this.f6180a.put(bmtVar, m3322p(value));
                return;
            }
        }
        bnr bnrVar = (bnr) value;
        throw null;
    }

    /* renamed from: r */
    private static boolean m3320r(Map.Entry entry) {
        bmt bmtVar = (bmt) entry.getKey();
        if (bmtVar.mo3297d() == bqa.MESSAGE) {
            if (bmtVar.mo3296e()) {
                for (boj bojVar : (List) entry.getValue()) {
                    if (!bojVar.mo3170aV()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof boj) {
                    if (!((boj) value).mo3170aV()) {
                        return false;
                    }
                } else if (value instanceof bnr) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    /* renamed from: s */
    private static final int m3319s(Map.Entry entry) {
        int m3367v;
        int m3368u;
        bmt bmtVar = (bmt) entry.getKey();
        Object value = entry.getValue();
        if (bmtVar.mo3297d() != bqa.MESSAGE || bmtVar.mo3296e()) {
            return m3336b(bmtVar, value);
        }
        bmtVar.mo3294g();
        if (value instanceof bnr) {
            int mo3300a = ((bmt) entry.getKey()).mo3300a();
            int m3368u2 = bma.m3368u(1);
            m3367v = m3368u2 + m3368u2 + bma.m3367v(2, mo3300a);
            m3368u = bma.m3379j(3, (bnr) value);
        } else {
            int mo3300a2 = ((bmt) entry.getKey()).mo3300a();
            int m3368u3 = bma.m3368u(1);
            m3367v = m3368u3 + m3368u3 + bma.m3367v(2, mo3300a2);
            m3368u = bma.m3368u(3) + bma.m3376m((boj) value);
        }
        return m3367v + m3368u;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m3318t(com.google.ads.interactivemedia.p034v3.internal.bmt r4, java.lang.Object r5) {
        /*
            com.google.ads.interactivemedia.v3.internal.bpz r0 = r4.mo3298c()
            com.google.ads.interactivemedia.p034v3.internal.bnk.m3260i(r5)
            com.google.ads.interactivemedia.v3.internal.bpz r1 = com.google.ads.interactivemedia.p034v3.internal.bpz.DOUBLE
            com.google.ads.interactivemedia.v3.internal.bqa r1 = com.google.ads.interactivemedia.p034v3.internal.bqa.INT
            com.google.ads.interactivemedia.v3.internal.bqa r0 = r0.m2858a()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r5 instanceof com.google.ads.interactivemedia.p034v3.internal.boj
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.ads.interactivemedia.p034v3.internal.bnr
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.ads.interactivemedia.p034v3.internal.bnf
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r5 instanceof com.google.ads.interactivemedia.p034v3.internal.bls
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L46
            goto L45
        L32:
            boolean r0 = r5 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r5 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r5 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r5 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r5 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
        L45:
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = 0
            int r3 = r4.mo3300a()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1[r2] = r3
            r2 = 1
            com.google.ads.interactivemedia.v3.internal.bpz r4 = r4.mo3298c()
            com.google.ads.interactivemedia.v3.internal.bqa r4 = r4.m2858a()
            r1[r2] = r4
            r4 = 2
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getName()
            r1[r4] = r5
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bmu.m3318t(com.google.ads.interactivemedia.v3.internal.bmt, java.lang.Object):void");
    }

    /* renamed from: c */
    public final int m3335c() {
        int i = 0;
        for (int i2 = 0; i2 < this.f6180a.m2969b(); i2++) {
            i += m3319s(this.f6180a.m2964g(i2));
        }
        for (Map.Entry entry : this.f6180a.m2967d()) {
            i += m3319s(entry);
        }
        return i;
    }

    /* renamed from: d */
    public final bmu clone() {
        bmu bmuVar = new bmu();
        for (int i = 0; i < this.f6180a.m2969b(); i++) {
            Map.Entry m2964g = this.f6180a.m2964g(i);
            bmuVar.m3327k((bmt) m2964g.getKey(), m2964g.getValue());
        }
        for (Map.Entry entry : this.f6180a.m2967d()) {
            bmuVar.m3327k((bmt) entry.getKey(), entry.getValue());
        }
        bmuVar.f6182d = this.f6182d;
        return bmuVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof bmu) {
            return this.f6180a.equals(((bmu) obj).f6180a);
        }
        return false;
    }

    /* renamed from: f */
    public final Object m3332f(bmt bmtVar) {
        Object obj = this.f6180a.get(bmtVar);
        if (obj instanceof bnr) {
            bnr bnrVar = (bnr) obj;
            throw null;
        }
        return obj;
    }

    /* renamed from: g */
    public final Iterator m3331g() {
        return this.f6182d ? new bnq(this.f6180a.entrySet().iterator()) : this.f6180a.entrySet().iterator();
    }

    /* renamed from: h */
    public final void m3330h(bmt bmtVar, Object obj) {
        List list;
        if (!((bnc) bmtVar).f6257d) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        m3318t(bmtVar, obj);
        Object m3332f = m3332f(bmtVar);
        if (m3332f == null) {
            list = new ArrayList();
            this.f6180a.put(bmtVar, list);
        } else {
            list = (List) m3332f;
        }
        list.add(obj);
    }

    public final int hashCode() {
        return this.f6180a.hashCode();
    }

    /* renamed from: i */
    public final void m3329i() {
        if (this.f6181c) {
            return;
        }
        this.f6180a.mo2970a();
        this.f6181c = true;
    }

    /* renamed from: j */
    public final void m3328j(bmu bmuVar) {
        for (int i = 0; i < bmuVar.f6180a.m2969b(); i++) {
            m3321q(bmuVar.f6180a.m2964g(i));
        }
        for (Map.Entry entry : bmuVar.f6180a.m2967d()) {
            m3321q(entry);
        }
    }

    /* renamed from: k */
    public final void m3327k(bmt bmtVar, Object obj) {
        if (bmtVar.mo3296e()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                m3318t(bmtVar, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            m3318t(bmtVar, obj);
        }
        if (obj instanceof bnr) {
            this.f6182d = true;
        }
        this.f6180a.put(bmtVar, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public final boolean m3326l() {
        return this.f6180a.isEmpty();
    }

    /* renamed from: m */
    public final boolean m3325m() {
        return this.f6181c;
    }

    /* renamed from: n */
    public final boolean m3324n() {
        for (int i = 0; i < this.f6180a.m2969b(); i++) {
            if (!m3320r(this.f6180a.m2964g(i))) {
                return false;
            }
        }
        for (Map.Entry entry : this.f6180a.m2967d()) {
            if (!m3320r(entry)) {
                return false;
            }
        }
        return true;
    }

    private bmu(byte[] bArr) {
        m3329i();
        m3329i();
    }
}
