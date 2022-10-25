package com.google.ads.interactivemedia.p034v3.internal;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p046rt.internal_b0d6a23.core.runtime.AgentOptions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.bmb */
/* loaded from: classes2.dex */
public final class bmb implements bqc {

    /* renamed from: a */
    private final bma f6067a;

    private bmb(bma bmaVar) {
        bnk.m3259j(bmaVar, AgentOptions.OUTPUT);
        this.f6067a = bmaVar;
        bmaVar.f6063a = this;
    }

    /* renamed from: a */
    public static bmb m3362a(bma bmaVar) {
        bmb bmbVar = bmaVar.f6063a;
        return bmbVar != null ? bmbVar : new bmb(bmaVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: A */
    public final void mo2850A(int i, long j) throws IOException {
        this.f6067a.m3410R(i, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: C */
    public final void mo2848C(int i, int i2) throws IOException {
        this.f6067a.m3420H(i, i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: E */
    public final void mo2846E(int i, long j) throws IOException {
        this.f6067a.m3419I(i, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    @Deprecated
    /* renamed from: G */
    public final void mo2844G(int i) throws IOException {
        this.f6067a.m3399ab(i, 3);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: H */
    public final void mo2843H(int i, String str) throws IOException {
        this.f6067a.m3402Z(i, str);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: I */
    public final void mo2842I(int i, List list) throws IOException {
        int i2 = 0;
        if (!(list instanceof bnu)) {
            while (i2 < list.size()) {
                this.f6067a.m3402Z(i, (String) list.get(i2));
                i2++;
            }
            return;
        }
        bnu bnuVar = (bnu) list;
        while (i2 < list.size()) {
            Object mo2938f = bnuVar.mo2938f(i2);
            if (mo2938f instanceof String) {
                this.f6067a.m3402Z(i, (String) mo2938f);
            } else {
                this.f6067a.m3413O(i, (bls) mo2938f);
            }
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: J */
    public final void mo2841J(int i, int i2) throws IOException {
        this.f6067a.m3398ac(i, i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: L */
    public final void mo2839L(int i, long j) throws IOException {
        this.f6067a.m3396ae(i, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: b */
    public final void mo2837b(int i, boolean z) throws IOException {
        this.f6067a.m3414N(i, z);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: d */
    public final void mo2835d(int i, bls blsVar) throws IOException {
        this.f6067a.m3413O(i, blsVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: e */
    public final void mo2834e(int i, List list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f6067a.m3413O(i, (bls) list.get(i2));
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: f */
    public final void mo2833f(int i, double d) throws IOException {
        this.f6067a.m3423E(i, d);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    @Deprecated
    /* renamed from: h */
    public final void mo2831h(int i) throws IOException {
        this.f6067a.m3399ab(i, 4);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: i */
    public final void mo2830i(int i, int i2) throws IOException {
        this.f6067a.m3408T(i, i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: k */
    public final void mo2828k(int i, int i2) throws IOException {
        this.f6067a.m3412P(i, i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: m */
    public final void mo2826m(int i, long j) throws IOException {
        this.f6067a.m3410R(i, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: o */
    public final void mo2824o(int i, float f) throws IOException {
        this.f6067a.m3422F(i, f);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: q */
    public final void mo2822q(int i, Object obj, boy boyVar) throws IOException {
        bma bmaVar = this.f6067a;
        bmaVar.m3399ab(i, 3);
        boyVar.mo3033j((boj) obj, bmaVar.f6063a);
        bmaVar.m3399ab(i, 4);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: r */
    public final void mo2821r(int i, int i2) throws IOException {
        this.f6067a.m3408T(i, i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: t */
    public final void mo2819t(int i, long j) throws IOException {
        this.f6067a.m3396ae(i, j);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: v */
    public final void mo2817v(int i, bod bodVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            this.f6067a.m3399ab(i, 2);
            this.f6067a.m3397ad(bqd.m2799N(bodVar, entry.getKey(), entry.getValue()));
            bqd.m2798O(this.f6067a, bodVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: w */
    public final void mo2816w(int i, Object obj, boy boyVar) throws IOException {
        this.f6067a.m3405W(i, (boj) obj, boyVar);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: x */
    public final void mo2815x(int i, Object obj) throws IOException {
        if (obj instanceof bls) {
            this.f6067a.m3403Y(i, (bls) obj);
        } else {
            this.f6067a.m3404X(i, (boj) obj);
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: y */
    public final void mo2814y(int i, int i2) throws IOException {
        this.f6067a.m3412P(i, i2);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: B */
    public final void mo2849B(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3410R(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3409S(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: D */
    public final void mo2847D(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3420H(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bma.m3373p(((Integer) list.get(i4)).intValue());
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3397ad(bma.m3363z(((Integer) list.get(i2)).intValue()));
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: F */
    public final void mo2845F(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3419I(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bma.m3371r(((Long) list.get(i4)).longValue());
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3395af(bma.m3427A(((Long) list.get(i2)).longValue()));
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: K */
    public final void mo2840K(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3398ac(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bma.m3366w(((Integer) list.get(i4)).intValue());
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3397ad(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: M */
    public final void mo2838M(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3396ae(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bma.m3364y(((Long) list.get(i4)).longValue());
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3395af(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: c */
    public final void mo2836c(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3414N(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Boolean) list.get(i4)).booleanValue();
            i3++;
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3416L(((Boolean) list.get(i2)).booleanValue() ? (byte) 1 : (byte) 0);
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: g */
    public final void mo2832g(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3423E(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Double) list.get(i4)).doubleValue();
            i3 += 8;
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3409S(Double.doubleToRawLongBits(((Double) list.get(i2)).doubleValue()));
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: j */
    public final void mo2829j(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3408T(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bma.m3381h(((Integer) list.get(i4)).intValue());
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3407U(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: l */
    public final void mo2827l(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3412P(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3411Q(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: n */
    public final void mo2825n(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3410R(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Long) list.get(i4)).longValue();
            i3 += 8;
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3409S(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: p */
    public final void mo2823p(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3422F(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Float) list.get(i4)).floatValue();
            i3 += 4;
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3411Q(Float.floatToRawIntBits(((Float) list.get(i2)).floatValue()));
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: s */
    public final void mo2820s(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3408T(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bma.m3381h(((Integer) list.get(i4)).intValue());
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3407U(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: u */
    public final void mo2818u(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3396ae(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += bma.m3364y(((Long) list.get(i4)).longValue());
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3395af(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.bqc
    /* renamed from: z */
    public final void mo2813z(int i, List list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f6067a.m3412P(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.f6067a.m3399ab(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            ((Integer) list.get(i4)).intValue();
            i3 += 4;
        }
        this.f6067a.m3397ad(i3);
        while (i2 < list.size()) {
            this.f6067a.m3411Q(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }
}
