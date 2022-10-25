package com.google.ads.interactivemedia.p034v3.internal;

import androidx.tvprovider.media.p009tv.TvContractCompat;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bly */
/* loaded from: classes2.dex */
public final class bly implements bot {

    /* renamed from: a */
    private final blw f6052a;

    /* renamed from: b */
    private int f6053b;

    /* renamed from: c */
    private int f6054c;

    /* renamed from: d */
    private int f6055d = 0;

    private bly(blw blwVar) {
        bnk.m3259j(blwVar, TvContractCompat.PARAM_INPUT);
        this.f6052a = blwVar;
        blwVar.f6049d = this;
    }

    /* renamed from: O */
    private final Object m3435O(boy boyVar, bmr bmrVar) throws IOException {
        int i = this.f6054c;
        this.f6054c = bqb.m2851c(bqb.m2853a(this.f6053b), 4);
        try {
            Object mo3038e = boyVar.mo3038e();
            boyVar.mo3035h(mo3038e, this, bmrVar);
            boyVar.mo3037f(mo3038e);
            if (this.f6053b == this.f6054c) {
                return mo3038e;
            }
            throw bnm.m3252g();
        } finally {
            this.f6054c = i;
        }
    }

    /* renamed from: V */
    private final Object m3434V(boy boyVar, bmr bmrVar) throws IOException {
        blw blwVar;
        int mo3445n = this.f6052a.mo3445n();
        blw blwVar2 = this.f6052a;
        if (blwVar2.f6046a >= blwVar2.f6047b) {
            throw new bnm("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int mo3452e = blwVar2.mo3452e(mo3445n);
        Object mo3038e = boyVar.mo3038e();
        this.f6052a.f6046a++;
        boyVar.mo3035h(mo3038e, this, bmrVar);
        boyVar.mo3037f(mo3038e);
        this.f6052a.mo3436z(0);
        blwVar.f6046a--;
        this.f6052a.mo3462A(mo3452e);
        return mo3038e;
    }

    /* renamed from: W */
    private final void m3433W(int i) throws IOException {
        if (this.f6052a.mo3453d() != i) {
            throw bnm.m3250i();
        }
    }

    /* renamed from: X */
    private final void m3432X(int i) throws IOException {
        if (bqb.m2852b(this.f6053b) != i) {
            throw bnm.m3258a();
        }
    }

    /* renamed from: Y */
    private static final void m3431Y(int i) throws IOException {
        if ((i & 3) != 0) {
            throw bnm.m3252g();
        }
    }

    /* renamed from: Z */
    private static final void m3430Z(int i) throws IOException {
        if ((i & 7) != 0) {
            throw bnm.m3252g();
        }
    }

    /* renamed from: p */
    public static bly m3429p(blw blwVar) {
        bly blyVar = blwVar.f6049d;
        return blyVar != null ? blyVar : new bly(blwVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: A */
    public final void mo3111A(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (list instanceof bmo) {
            bmo bmoVar = (bmo) list;
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 1) {
                do {
                    bmoVar.m3346e(this.f6052a.mo3455b());
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m2 = this.f6052a.mo3446m();
                } while (mo3446m2 == this.f6053b);
                this.f6055d = mo3446m2;
                return;
            } else if (m2852b == 2) {
                int mo3445n = this.f6052a.mo3445n();
                m3430Z(mo3445n);
                int mo3453d = this.f6052a.mo3453d() + mo3445n;
                do {
                    bmoVar.m3346e(this.f6052a.mo3455b());
                } while (this.f6052a.mo3453d() < mo3453d);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 1) {
            do {
                list.add(Double.valueOf(this.f6052a.mo3455b()));
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
        } else if (m2852b2 == 2) {
            int mo3445n2 = this.f6052a.mo3445n();
            m3430Z(mo3445n2);
            int mo3453d2 = this.f6052a.mo3453d() + mo3445n2;
            do {
                list.add(Double.valueOf(this.f6052a.mo3455b()));
            } while (this.f6052a.mo3453d() < mo3453d2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: B */
    public final void mo3110B(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 0) {
                do {
                    bneVar.m3273g(this.f6052a.mo3451f());
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m2 = this.f6052a.mo3446m();
                } while (mo3446m2 == this.f6053b);
                this.f6055d = mo3446m2;
                return;
            } else if (m2852b == 2) {
                int mo3453d = this.f6052a.mo3453d() + this.f6052a.mo3445n();
                do {
                    bneVar.m3273g(this.f6052a.mo3451f());
                } while (this.f6052a.mo3453d() < mo3453d);
                m3433W(mo3453d);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 0) {
            do {
                list.add(Integer.valueOf(this.f6052a.mo3451f()));
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
        } else if (m2852b2 == 2) {
            int mo3453d2 = this.f6052a.mo3453d() + this.f6052a.mo3445n();
            do {
                list.add(Integer.valueOf(this.f6052a.mo3451f()));
            } while (this.f6052a.mo3453d() < mo3453d2);
            m3433W(mo3453d2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: C */
    public final void mo3109C(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (!(list instanceof bne)) {
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 2) {
                int mo3445n = this.f6052a.mo3445n();
                m3431Y(mo3445n);
                int mo3453d = this.f6052a.mo3453d() + mo3445n;
                do {
                    list.add(Integer.valueOf(this.f6052a.mo3450g()));
                } while (this.f6052a.mo3453d() < mo3453d);
                return;
            } else if (m2852b != 5) {
                throw bnm.m3258a();
            } else {
                do {
                    list.add(Integer.valueOf(this.f6052a.mo3450g()));
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m = this.f6052a.mo3446m();
                } while (mo3446m == this.f6053b);
                this.f6055d = mo3446m;
                return;
            }
        }
        bne bneVar = (bne) list;
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 2) {
            int mo3445n2 = this.f6052a.mo3445n();
            m3431Y(mo3445n2);
            int mo3453d2 = this.f6052a.mo3453d() + mo3445n2;
            do {
                bneVar.m3273g(this.f6052a.mo3450g());
            } while (this.f6052a.mo3453d() < mo3453d2);
        } else if (m2852b2 != 5) {
            throw bnm.m3258a();
        } else {
            do {
                bneVar.m3273g(this.f6052a.mo3450g());
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m2 = this.f6052a.mo3446m();
            } while (mo3446m2 == this.f6053b);
            this.f6055d = mo3446m2;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: D */
    public final void mo3108D(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 1) {
                do {
                    bnzVar.m3199f(this.f6052a.mo3444o());
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m2 = this.f6052a.mo3446m();
                } while (mo3446m2 == this.f6053b);
                this.f6055d = mo3446m2;
                return;
            } else if (m2852b == 2) {
                int mo3445n = this.f6052a.mo3445n();
                m3430Z(mo3445n);
                int mo3453d = this.f6052a.mo3453d() + mo3445n;
                do {
                    bnzVar.m3199f(this.f6052a.mo3444o());
                } while (this.f6052a.mo3453d() < mo3453d);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 1) {
            do {
                list.add(Long.valueOf(this.f6052a.mo3444o()));
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
        } else if (m2852b2 == 2) {
            int mo3445n2 = this.f6052a.mo3445n();
            m3430Z(mo3445n2);
            int mo3453d2 = this.f6052a.mo3453d() + mo3445n2;
            do {
                list.add(Long.valueOf(this.f6052a.mo3444o()));
            } while (this.f6052a.mo3453d() < mo3453d2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: E */
    public final void mo3107E(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (!(list instanceof bmx)) {
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 2) {
                int mo3445n = this.f6052a.mo3445n();
                m3431Y(mo3445n);
                int mo3453d = this.f6052a.mo3453d() + mo3445n;
                do {
                    list.add(Float.valueOf(this.f6052a.mo3454c()));
                } while (this.f6052a.mo3453d() < mo3453d);
                return;
            } else if (m2852b != 5) {
                throw bnm.m3258a();
            } else {
                do {
                    list.add(Float.valueOf(this.f6052a.mo3454c()));
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m = this.f6052a.mo3446m();
                } while (mo3446m == this.f6053b);
                this.f6055d = mo3446m;
                return;
            }
        }
        bmx bmxVar = (bmx) list;
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 2) {
            int mo3445n2 = this.f6052a.mo3445n();
            m3431Y(mo3445n2);
            int mo3453d2 = this.f6052a.mo3453d() + mo3445n2;
            do {
                bmxVar.m3316e(this.f6052a.mo3454c());
            } while (this.f6052a.mo3453d() < mo3453d2);
        } else if (m2852b2 != 5) {
            throw bnm.m3258a();
        } else {
            do {
                bmxVar.m3316e(this.f6052a.mo3454c());
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m2 = this.f6052a.mo3446m();
            } while (mo3446m2 == this.f6053b);
            this.f6055d = mo3446m2;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    @Deprecated
    /* renamed from: F */
    public final void mo3106F(List list, boy boyVar, bmr bmrVar) throws IOException {
        int mo3446m;
        int i = this.f6053b;
        if (bqb.m2852b(i) != 3) {
            throw bnm.m3258a();
        }
        do {
            list.add(m3435O(boyVar, bmrVar));
            if (this.f6052a.mo3461C() || this.f6055d != 0) {
                return;
            }
            mo3446m = this.f6052a.mo3446m();
        } while (mo3446m == i);
        this.f6055d = mo3446m;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: G */
    public final void mo3105G(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 0) {
                do {
                    bneVar.m3273g(this.f6052a.mo3449h());
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m2 = this.f6052a.mo3446m();
                } while (mo3446m2 == this.f6053b);
                this.f6055d = mo3446m2;
                return;
            } else if (m2852b == 2) {
                int mo3453d = this.f6052a.mo3453d() + this.f6052a.mo3445n();
                do {
                    bneVar.m3273g(this.f6052a.mo3449h());
                } while (this.f6052a.mo3453d() < mo3453d);
                m3433W(mo3453d);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 0) {
            do {
                list.add(Integer.valueOf(this.f6052a.mo3449h()));
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
        } else if (m2852b2 == 2) {
            int mo3453d2 = this.f6052a.mo3453d() + this.f6052a.mo3445n();
            do {
                list.add(Integer.valueOf(this.f6052a.mo3449h()));
            } while (this.f6052a.mo3453d() < mo3453d2);
            m3433W(mo3453d2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: H */
    public final void mo3104H(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 0) {
                do {
                    bnzVar.m3199f(this.f6052a.mo3443p());
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m2 = this.f6052a.mo3446m();
                } while (mo3446m2 == this.f6053b);
                this.f6055d = mo3446m2;
                return;
            } else if (m2852b == 2) {
                int mo3453d = this.f6052a.mo3453d() + this.f6052a.mo3445n();
                do {
                    bnzVar.m3199f(this.f6052a.mo3443p());
                } while (this.f6052a.mo3453d() < mo3453d);
                m3433W(mo3453d);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 0) {
            do {
                list.add(Long.valueOf(this.f6052a.mo3443p()));
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
        } else if (m2852b2 == 2) {
            int mo3453d2 = this.f6052a.mo3453d() + this.f6052a.mo3445n();
            do {
                list.add(Long.valueOf(this.f6052a.mo3443p()));
            } while (this.f6052a.mo3453d() < mo3453d2);
            m3433W(mo3453d2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: I */
    public final void mo3103I(List list, boy boyVar, bmr bmrVar) throws IOException {
        int mo3446m;
        int i = this.f6053b;
        if (bqb.m2852b(i) != 2) {
            throw bnm.m3258a();
        }
        do {
            list.add(m3434V(boyVar, bmrVar));
            if (this.f6052a.mo3461C() || this.f6055d != 0) {
                return;
            }
            mo3446m = this.f6052a.mo3446m();
        } while (mo3446m == i);
        this.f6055d = mo3446m;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: J */
    public final void mo3102J(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (!(list instanceof bne)) {
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 2) {
                int mo3445n = this.f6052a.mo3445n();
                m3431Y(mo3445n);
                int mo3453d = this.f6052a.mo3453d() + mo3445n;
                do {
                    list.add(Integer.valueOf(this.f6052a.mo3448k()));
                } while (this.f6052a.mo3453d() < mo3453d);
                return;
            } else if (m2852b != 5) {
                throw bnm.m3258a();
            } else {
                do {
                    list.add(Integer.valueOf(this.f6052a.mo3448k()));
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m = this.f6052a.mo3446m();
                } while (mo3446m == this.f6053b);
                this.f6055d = mo3446m;
                return;
            }
        }
        bne bneVar = (bne) list;
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 2) {
            int mo3445n2 = this.f6052a.mo3445n();
            m3431Y(mo3445n2);
            int mo3453d2 = this.f6052a.mo3453d() + mo3445n2;
            do {
                bneVar.m3273g(this.f6052a.mo3448k());
            } while (this.f6052a.mo3453d() < mo3453d2);
        } else if (m2852b2 != 5) {
            throw bnm.m3258a();
        } else {
            do {
                bneVar.m3273g(this.f6052a.mo3448k());
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m2 = this.f6052a.mo3446m();
            } while (mo3446m2 == this.f6053b);
            this.f6055d = mo3446m2;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: K */
    public final void mo3101K(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 1) {
                do {
                    bnzVar.m3199f(this.f6052a.mo3442t());
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m2 = this.f6052a.mo3446m();
                } while (mo3446m2 == this.f6053b);
                this.f6055d = mo3446m2;
                return;
            } else if (m2852b == 2) {
                int mo3445n = this.f6052a.mo3445n();
                m3430Z(mo3445n);
                int mo3453d = this.f6052a.mo3453d() + mo3445n;
                do {
                    bnzVar.m3199f(this.f6052a.mo3442t());
                } while (this.f6052a.mo3453d() < mo3453d);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 1) {
            do {
                list.add(Long.valueOf(this.f6052a.mo3442t()));
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
        } else if (m2852b2 == 2) {
            int mo3445n2 = this.f6052a.mo3445n();
            m3430Z(mo3445n2);
            int mo3453d2 = this.f6052a.mo3453d() + mo3445n2;
            do {
                list.add(Long.valueOf(this.f6052a.mo3442t()));
            } while (this.f6052a.mo3453d() < mo3453d2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: L */
    public final void mo3100L(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 0) {
                do {
                    bneVar.m3273g(this.f6052a.mo3447l());
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m2 = this.f6052a.mo3446m();
                } while (mo3446m2 == this.f6053b);
                this.f6055d = mo3446m2;
                return;
            } else if (m2852b == 2) {
                int mo3453d = this.f6052a.mo3453d() + this.f6052a.mo3445n();
                do {
                    bneVar.m3273g(this.f6052a.mo3447l());
                } while (this.f6052a.mo3453d() < mo3453d);
                m3433W(mo3453d);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 0) {
            do {
                list.add(Integer.valueOf(this.f6052a.mo3447l()));
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
        } else if (m2852b2 == 2) {
            int mo3453d2 = this.f6052a.mo3453d() + this.f6052a.mo3445n();
            do {
                list.add(Integer.valueOf(this.f6052a.mo3447l()));
            } while (this.f6052a.mo3453d() < mo3453d2);
            m3433W(mo3453d2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: M */
    public final void mo3099M(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 0) {
                do {
                    bnzVar.m3199f(this.f6052a.mo3441u());
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m2 = this.f6052a.mo3446m();
                } while (mo3446m2 == this.f6053b);
                this.f6055d = mo3446m2;
                return;
            } else if (m2852b == 2) {
                int mo3453d = this.f6052a.mo3453d() + this.f6052a.mo3445n();
                do {
                    bnzVar.m3199f(this.f6052a.mo3441u());
                } while (this.f6052a.mo3453d() < mo3453d);
                m3433W(mo3453d);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 0) {
            do {
                list.add(Long.valueOf(this.f6052a.mo3441u()));
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
        } else if (m2852b2 == 2) {
            int mo3453d2 = this.f6052a.mo3453d() + this.f6052a.mo3445n();
            do {
                list.add(Long.valueOf(this.f6052a.mo3441u()));
            } while (this.f6052a.mo3453d() < mo3453d2);
            m3433W(mo3453d2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: N */
    public final void mo3098N(List list) throws IOException {
        m3428w(list, false);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: P */
    public final void mo3097P(List list) throws IOException {
        m3428w(list, true);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: Q */
    public final void mo3096Q(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (list instanceof bne) {
            bne bneVar = (bne) list;
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 0) {
                do {
                    bneVar.m3273g(this.f6052a.mo3445n());
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m2 = this.f6052a.mo3446m();
                } while (mo3446m2 == this.f6053b);
                this.f6055d = mo3446m2;
                return;
            } else if (m2852b == 2) {
                int mo3453d = this.f6052a.mo3453d() + this.f6052a.mo3445n();
                do {
                    bneVar.m3273g(this.f6052a.mo3445n());
                } while (this.f6052a.mo3453d() < mo3453d);
                m3433W(mo3453d);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 0) {
            do {
                list.add(Integer.valueOf(this.f6052a.mo3445n()));
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
        } else if (m2852b2 == 2) {
            int mo3453d2 = this.f6052a.mo3453d() + this.f6052a.mo3445n();
            do {
                list.add(Integer.valueOf(this.f6052a.mo3445n()));
            } while (this.f6052a.mo3453d() < mo3453d2);
            m3433W(mo3453d2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: R */
    public final void mo3095R(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (list instanceof bnz) {
            bnz bnzVar = (bnz) list;
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 0) {
                do {
                    bnzVar.m3199f(this.f6052a.mo3440v());
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m2 = this.f6052a.mo3446m();
                } while (mo3446m2 == this.f6053b);
                this.f6055d = mo3446m2;
                return;
            } else if (m2852b == 2) {
                int mo3453d = this.f6052a.mo3453d() + this.f6052a.mo3445n();
                do {
                    bnzVar.m3199f(this.f6052a.mo3440v());
                } while (this.f6052a.mo3453d() < mo3453d);
                m3433W(mo3453d);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 0) {
            do {
                list.add(Long.valueOf(this.f6052a.mo3440v()));
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
        } else if (m2852b2 == 2) {
            int mo3453d2 = this.f6052a.mo3453d() + this.f6052a.mo3445n();
            do {
                list.add(Long.valueOf(this.f6052a.mo3440v()));
            } while (this.f6052a.mo3453d() < mo3453d2);
            m3433W(mo3453d2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: S */
    public final boolean mo3094S() throws IOException {
        m3432X(0);
        return this.f6052a.mo3460D();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: T */
    public final boolean mo3093T() throws IOException {
        int i;
        if (this.f6052a.mo3461C() || (i = this.f6053b) == this.f6054c) {
            return false;
        }
        return this.f6052a.mo3459E(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: U */
    public final void mo3092U(Map map, bod bodVar) throws IOException {
        m3432X(2);
        int mo3452e = this.f6052a.mo3452e(this.f6052a.mo3445n());
        Object obj = bodVar.f6311b;
        Object obj2 = bodVar.f6313d;
        while (true) {
            try {
                int mo3089c = mo3089c();
                if (mo3089c == Integer.MAX_VALUE || this.f6052a.mo3461C()) {
                    break;
                } else if (mo3089c == 1) {
                    bpz bpzVar = bodVar.f6310a;
                    int i = blx.f6051b;
                    throw null;
                } else if (mo3089c == 2) {
                    bpz bpzVar2 = bodVar.f6312c;
                    Object obj3 = bodVar.f6313d;
                    throw null;
                } else {
                    try {
                    } catch (bnl unused) {
                        if (!mo3093T()) {
                            throw new bnm("Unable to parse map entry.");
                        }
                    }
                    if (!mo3093T()) {
                        throw new bnm("Unable to parse map entry.");
                    }
                }
            } finally {
                this.f6052a.mo3462A(mo3452e);
            }
        }
        map.put(null, null);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: a */
    public final double mo3091a() throws IOException {
        m3432X(1);
        return this.f6052a.mo3455b();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: b */
    public final float mo3090b() throws IOException {
        m3432X(5);
        return this.f6052a.mo3454c();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: c */
    public final int mo3089c() throws IOException {
        int i = this.f6055d;
        if (i != 0) {
            this.f6053b = i;
            this.f6055d = 0;
        } else {
            i = this.f6052a.mo3446m();
            this.f6053b = i;
        }
        if (i == 0 || i == this.f6054c) {
            return Integer.MAX_VALUE;
        }
        return bqb.m2853a(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: d */
    public final int mo3088d() {
        return this.f6053b;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: e */
    public final int mo3087e() throws IOException {
        m3432X(0);
        return this.f6052a.mo3451f();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: f */
    public final int mo3086f() throws IOException {
        m3432X(5);
        return this.f6052a.mo3450g();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: g */
    public final int mo3085g() throws IOException {
        m3432X(0);
        return this.f6052a.mo3449h();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: h */
    public final int mo3084h() throws IOException {
        m3432X(5);
        return this.f6052a.mo3448k();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: i */
    public final int mo3083i() throws IOException {
        m3432X(0);
        return this.f6052a.mo3447l();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: j */
    public final int mo3082j() throws IOException {
        m3432X(0);
        return this.f6052a.mo3445n();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: k */
    public final long mo3081k() throws IOException {
        m3432X(1);
        return this.f6052a.mo3444o();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: l */
    public final long mo3080l() throws IOException {
        m3432X(0);
        return this.f6052a.mo3443p();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: m */
    public final long mo3079m() throws IOException {
        m3432X(1);
        return this.f6052a.mo3442t();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: n */
    public final long mo3078n() throws IOException {
        m3432X(0);
        return this.f6052a.mo3441u();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: o */
    public final long mo3077o() throws IOException {
        m3432X(0);
        return this.f6052a.mo3440v();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: q */
    public final bls mo3076q() throws IOException {
        m3432X(2);
        return this.f6052a.mo3439w();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    @Deprecated
    /* renamed from: r */
    public final Object mo3075r(Class cls, bmr bmrVar) throws IOException {
        m3432X(3);
        return m3435O(boq.m3120a().m3119b(cls), bmrVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    @Deprecated
    /* renamed from: s */
    public final Object mo3074s(boy boyVar, bmr bmrVar) throws IOException {
        m3432X(3);
        return m3435O(boyVar, bmrVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: t */
    public final Object mo3073t(Class cls, bmr bmrVar) throws IOException {
        m3432X(2);
        return m3434V(boq.m3120a().m3119b(cls), bmrVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: u */
    public final Object mo3072u(boy boyVar, bmr bmrVar) throws IOException {
        m3432X(2);
        return m3434V(boyVar, bmrVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: v */
    public final String mo3071v() throws IOException {
        m3432X(2);
        return this.f6052a.mo3438x();
    }

    /* renamed from: w */
    public final void m3428w(List list, boolean z) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (bqb.m2852b(this.f6053b) != 2) {
            throw bnm.m3258a();
        }
        if (!(list instanceof bnu) || z) {
            do {
                list.add(z ? mo3070x() : mo3071v());
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
            return;
        }
        bnu bnuVar = (bnu) list;
        do {
            bnuVar.mo2936i(mo3076q());
            if (this.f6052a.mo3461C()) {
                return;
            }
            mo3446m2 = this.f6052a.mo3446m();
        } while (mo3446m2 == this.f6053b);
        this.f6055d = mo3446m2;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: x */
    public final String mo3070x() throws IOException {
        m3432X(2);
        return this.f6052a.mo3437y();
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: y */
    public final void mo3069y(List list) throws IOException {
        int mo3446m;
        int mo3446m2;
        if (list instanceof blj) {
            blj bljVar = (blj) list;
            int m2852b = bqb.m2852b(this.f6053b);
            if (m2852b == 0) {
                do {
                    bljVar.m3517e(this.f6052a.mo3460D());
                    if (this.f6052a.mo3461C()) {
                        return;
                    }
                    mo3446m2 = this.f6052a.mo3446m();
                } while (mo3446m2 == this.f6053b);
                this.f6055d = mo3446m2;
                return;
            } else if (m2852b == 2) {
                int mo3453d = this.f6052a.mo3453d() + this.f6052a.mo3445n();
                do {
                    bljVar.m3517e(this.f6052a.mo3460D());
                } while (this.f6052a.mo3453d() < mo3453d);
                m3433W(mo3453d);
                return;
            } else {
                throw bnm.m3258a();
            }
        }
        int m2852b2 = bqb.m2852b(this.f6053b);
        if (m2852b2 == 0) {
            do {
                list.add(Boolean.valueOf(this.f6052a.mo3460D()));
                if (this.f6052a.mo3461C()) {
                    return;
                }
                mo3446m = this.f6052a.mo3446m();
            } while (mo3446m == this.f6053b);
            this.f6055d = mo3446m;
        } else if (m2852b2 == 2) {
            int mo3453d2 = this.f6052a.mo3453d() + this.f6052a.mo3445n();
            do {
                list.add(Boolean.valueOf(this.f6052a.mo3460D()));
            } while (this.f6052a.mo3453d() < mo3453d2);
            m3433W(mo3453d2);
        } else {
            throw bnm.m3258a();
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bot
    /* renamed from: z */
    public final void mo3068z(List list) throws IOException {
        int mo3446m;
        if (bqb.m2852b(this.f6053b) != 2) {
            throw bnm.m3258a();
        }
        do {
            list.add(mo3076q());
            if (this.f6052a.mo3461C()) {
                return;
            }
            mo3446m = this.f6052a.mo3446m();
        } while (mo3446m == this.f6053b);
        this.f6055d = mo3446m;
    }
}
