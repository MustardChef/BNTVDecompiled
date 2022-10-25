package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import android.os.SystemClock;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.pn */
/* loaded from: classes2.dex */
final class C2976pn implements InterfaceC2996qg {

    /* renamed from: a */
    final /* synthetic */ C2979pq f8468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ C2976pn(C2979pq c2979pq) {
        this.f8468a = c2979pq;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2996qg
    /* renamed from: j */
    public final void mo1324j() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        copyOnWriteArrayList = this.f8468a.f8485d;
        copyOnWriteArrayList.remove(this);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC2996qg
    /* renamed from: s */
    public final boolean mo1323s(Uri uri, C3159wh c3159wh, boolean z) {
        C2990qa c2990qa;
        C2983pu c2983pu;
        C2983pu c2983pu2;
        HashMap hashMap;
        HashMap hashMap2;
        long j;
        c2990qa = this.f8468a.f8492k;
        if (c2990qa == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            c2983pu = this.f8468a.f8490i;
            int i = C2628cq.f6961a;
            List list = c2983pu.f8510c;
            int i2 = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                hashMap2 = this.f8468a.f8484c;
                C2978pp c2978pp = (C2978pp) hashMap2.get(((C2982pt) list.get(i3)).f8502a);
                if (c2978pp != null) {
                    j = c2978pp.f8479i;
                    if (elapsedRealtime < j) {
                        i2++;
                    }
                }
            }
            c2983pu2 = this.f8468a.f8490i;
            C3158wg m740a = C3161wj.m740a(new C3157wf(1, 0, c2983pu2.f8510c.size(), i2), c3159wh);
            if (m740a != null && m740a.f9294a == 2) {
                hashMap = this.f8468a.f8484c;
                C2978pp c2978pp2 = (C2978pp) hashMap.get(uri);
                if (c2978pp2 != null) {
                    C2978pp.m1369n(c2978pp2, m740a.f9295b);
                }
            }
        }
        return false;
    }
}
