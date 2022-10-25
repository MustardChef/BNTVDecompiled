package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bom */
/* loaded from: classes2.dex */
final class bom implements boy {

    /* renamed from: a */
    private final boj f6337a;

    /* renamed from: b */
    private final boolean f6338b;

    /* renamed from: c */
    private final bqd f6339c;

    /* renamed from: d */
    private final bnv f6340d;

    private bom(bqd bqdVar, bnv bnvVar, boj bojVar, byte[] bArr) {
        this.f6339c = bqdVar;
        this.f6338b = bnv.m3216as(bojVar);
        this.f6340d = bnvVar;
        this.f6337a = bojVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static bom m3124c(bqd bqdVar, bnv bnvVar, boj bojVar) {
        return new bom(bqdVar, bnvVar, bojVar, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: a */
    public final int mo3040a(Object obj) {
        int m2950b;
        m2950b = ((bpm) this.f6339c.m2784j(obj)).m2950b();
        return this.f6338b ? m2950b + bnv.m3218aq(obj).m3335c() : m2950b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: b */
    public final int mo3039b(Object obj) {
        int hashCode = this.f6339c.m2784j(obj).hashCode();
        return this.f6338b ? (hashCode * 53) + bnv.m3218aq(obj).hashCode() : hashCode;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: e */
    public final Object mo3038e() {
        return this.f6337a.mo3174bh().mo3178aS();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: f */
    public final void mo3037f(Object obj) {
        this.f6339c.m2783k(obj);
        this.f6340d.m3221an(obj);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: g */
    public final void mo3036g(Object obj, Object obj2) {
        bpa.m3004Z(this.f6339c, obj, obj2);
        if (this.f6338b) {
            bpa.m3005Y(this.f6340d, obj, obj2);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: h */
    public final void mo3035h(Object obj, bot botVar, bmr bmrVar) throws IOException {
        boolean mo3093T;
        bqd bqdVar = this.f6339c;
        Object m2785i = bqdVar.m2785i(obj);
        bmu m3217ar = bnv.m3217ar(obj);
        while (botVar.mo3089c() != Integer.MAX_VALUE) {
            try {
                int mo3088d = botVar.mo3088d();
                if (mo3088d != bqb.f6445a) {
                    if (bqb.m2852b(mo3088d) == 2) {
                        Object m3219ap = bnv.m3219ap(bmrVar, this.f6337a, bqb.m2853a(mo3088d));
                        if (m3219ap != null) {
                            bnv.m3215at(botVar, m3219ap, bmrVar, m3217ar);
                        } else {
                            mo3093T = bqdVar.m2786h(m2785i, botVar);
                        }
                    } else {
                        mo3093T = botVar.mo3093T();
                    }
                    if (!mo3093T) {
                        return;
                    }
                } else {
                    int i = 0;
                    Object obj2 = null;
                    bls blsVar = null;
                    while (botVar.mo3089c() != Integer.MAX_VALUE) {
                        int mo3088d2 = botVar.mo3088d();
                        if (mo3088d2 == bqb.f6447c) {
                            i = botVar.mo3082j();
                            obj2 = bnv.m3219ap(bmrVar, this.f6337a, i);
                        } else if (mo3088d2 == bqb.f6448d) {
                            if (obj2 != null) {
                                bnv.m3215at(botVar, obj2, bmrVar, m3217ar);
                            } else {
                                blsVar = botVar.mo3076q();
                            }
                        } else if (!botVar.mo3093T()) {
                            break;
                        }
                    }
                    if (botVar.mo3088d() != bqb.f6446b) {
                        throw bnm.m3257b();
                    } else if (blsVar != null) {
                        if (obj2 != null) {
                            bnv.m3214au(blsVar, obj2, bmrVar, m3217ar);
                        } else {
                            bqd.m2777q(m2785i, i, blsVar);
                        }
                    }
                }
            } finally {
                bqdVar.m2782l(obj, m2785i);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3 A[EDGE_INSN: B:56:0x00c3->B:33:0x00c3 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo3034i(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.ads.interactivemedia.p034v3.internal.blf r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.ads.interactivemedia.v3.internal.bnd r0 = (com.google.ads.interactivemedia.p034v3.internal.bnd) r0
            com.google.ads.interactivemedia.v3.internal.bpm r1 = r0.f6259c
            com.google.ads.interactivemedia.v3.internal.bpm r2 = com.google.ads.interactivemedia.p034v3.internal.bpm.m2949c()
            if (r1 != r2) goto L11
            com.google.ads.interactivemedia.v3.internal.bpm r1 = com.google.ads.interactivemedia.p034v3.internal.bpm.m2947e()
            r0.f6259c = r1
        L11:
            com.google.ads.interactivemedia.v3.internal.bnb r11 = (com.google.ads.interactivemedia.p034v3.internal.bnb) r11
            com.google.ads.interactivemedia.v3.internal.bmu r11 = r11.m3301f()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Lcf
            int r4 = com.google.ads.interactivemedia.p034v3.internal.bnv.m3227aK(r12, r13, r15)
            int r13 = r15.f5994a
            int r3 = com.google.ads.interactivemedia.p034v3.internal.bqb.f6445a
            r5 = 2
            if (r13 == r3) goto L67
            int r3 = com.google.ads.interactivemedia.p034v3.internal.bqb.m2852b(r13)
            if (r3 != r5) goto L62
            com.google.ads.interactivemedia.v3.internal.bmr r2 = r15.f5997d
            com.google.ads.interactivemedia.v3.internal.boj r3 = r10.f6337a
            int r5 = com.google.ads.interactivemedia.p034v3.internal.bqb.m2853a(r13)
            java.lang.Object r8 = com.google.ads.interactivemedia.p034v3.internal.bnv.m3219ap(r2, r3, r5)
            if (r8 == 0) goto L57
            com.google.ads.interactivemedia.v3.internal.boq r13 = com.google.ads.interactivemedia.p034v3.internal.boq.m3120a()
            r2 = r8
            com.google.ads.interactivemedia.v3.internal.bmp r2 = (com.google.ads.interactivemedia.p034v3.internal.bmp) r2
            com.google.ads.interactivemedia.v3.internal.boj r3 = r2.f6168a
            java.lang.Class r3 = r3.getClass()
            com.google.ads.interactivemedia.v3.internal.boy r13 = r13.m3119b(r3)
            int r13 = com.google.ads.interactivemedia.p034v3.internal.bnv.m3233aE(r13, r12, r4, r14, r15)
            com.google.ads.interactivemedia.v3.internal.bnc r2 = r2.f6169b
            java.lang.Object r3 = r15.f5996c
            r11.m3327k(r2, r3)
            goto L60
        L57:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.ads.interactivemedia.p034v3.internal.bnv.m3228aJ(r2, r3, r4, r5, r6, r7)
        L60:
            r2 = r8
            goto L19
        L62:
            int r13 = com.google.ads.interactivemedia.p034v3.internal.bnv.m3223aO(r13, r12, r4, r14, r15)
            goto L19
        L67:
            r13 = 0
            r3 = r0
        L69:
            if (r4 >= r14) goto Lc3
            int r4 = com.google.ads.interactivemedia.p034v3.internal.bnv.m3227aK(r12, r4, r15)
            int r6 = r15.f5994a
            int r7 = com.google.ads.interactivemedia.p034v3.internal.bqb.m2852b(r6)
            int r8 = com.google.ads.interactivemedia.p034v3.internal.bqb.m2853a(r6)
            if (r8 == r5) goto La9
            r9 = 3
            if (r8 == r9) goto L7f
            goto Lba
        L7f:
            if (r2 == 0) goto L9e
            com.google.ads.interactivemedia.v3.internal.boq r6 = com.google.ads.interactivemedia.p034v3.internal.boq.m3120a()
            r7 = r2
            com.google.ads.interactivemedia.v3.internal.bmp r7 = (com.google.ads.interactivemedia.p034v3.internal.bmp) r7
            com.google.ads.interactivemedia.v3.internal.boj r8 = r7.f6168a
            java.lang.Class r8 = r8.getClass()
            com.google.ads.interactivemedia.v3.internal.boy r6 = r6.m3119b(r8)
            int r4 = com.google.ads.interactivemedia.p034v3.internal.bnv.m3233aE(r6, r12, r4, r14, r15)
            com.google.ads.interactivemedia.v3.internal.bnc r6 = r7.f6169b
            java.lang.Object r7 = r15.f5996c
            r11.m3327k(r6, r7)
            goto L69
        L9e:
            if (r7 != r5) goto Lba
            int r4 = com.google.ads.interactivemedia.p034v3.internal.bnv.m3236aB(r12, r4, r15)
            java.lang.Object r3 = r15.f5996c
            com.google.ads.interactivemedia.v3.internal.bls r3 = (com.google.ads.interactivemedia.p034v3.internal.bls) r3
            goto L69
        La9:
            if (r7 != 0) goto Lba
            int r4 = com.google.ads.interactivemedia.p034v3.internal.bnv.m3227aK(r12, r4, r15)
            int r13 = r15.f5994a
            com.google.ads.interactivemedia.v3.internal.bmr r2 = r15.f5997d
            com.google.ads.interactivemedia.v3.internal.boj r6 = r10.f6337a
            java.lang.Object r2 = com.google.ads.interactivemedia.p034v3.internal.bnv.m3219ap(r2, r6, r13)
            goto L69
        Lba:
            int r7 = com.google.ads.interactivemedia.p034v3.internal.bqb.f6446b
            if (r6 == r7) goto Lc3
            int r4 = com.google.ads.interactivemedia.p034v3.internal.bnv.m3223aO(r6, r12, r4, r14, r15)
            goto L69
        Lc3:
            if (r3 == 0) goto Lcc
            int r13 = com.google.ads.interactivemedia.p034v3.internal.bqb.m2851c(r13, r5)
            r1.m2944h(r13, r3)
        Lcc:
            r13 = r4
            goto L19
        Lcf:
            if (r13 != r14) goto Ld2
            return
        Ld2:
            com.google.ads.interactivemedia.v3.internal.bnm r11 = com.google.ads.interactivemedia.p034v3.internal.bnm.m3252g()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.p034v3.internal.bom.mo3034i(java.lang.Object, byte[], int, int, com.google.ads.interactivemedia.v3.internal.blf):void");
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: j */
    public final void mo3033j(Object obj, bqc bqcVar) throws IOException {
        Iterator m3331g = bnv.m3218aq(obj).m3331g();
        while (m3331g.hasNext()) {
            Map.Entry entry = (Map.Entry) m3331g.next();
            bmt bmtVar = (bmt) entry.getKey();
            if (bmtVar.mo3297d() == bqa.MESSAGE && !bmtVar.mo3296e()) {
                bmtVar.mo3294g();
                if (entry instanceof bnp) {
                    bqcVar.mo2815x(bmtVar.mo3300a(), ((bnp) entry).m3244a().m3242b());
                } else {
                    bqcVar.mo2815x(bmtVar.mo3300a(), entry.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        ((bpm) this.f6339c.m2784j(obj)).m2943i(bqcVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: k */
    public final boolean mo3032k(Object obj, Object obj2) {
        if (this.f6339c.m2784j(obj).equals(this.f6339c.m2784j(obj2))) {
            if (this.f6338b) {
                return bnv.m3218aq(obj).equals(bnv.m3218aq(obj2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.boy
    /* renamed from: l */
    public final boolean mo3031l(Object obj) {
        return bnv.m3218aq(obj).m3324n();
    }
}
