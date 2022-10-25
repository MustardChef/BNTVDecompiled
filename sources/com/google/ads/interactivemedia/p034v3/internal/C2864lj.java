package com.google.ads.interactivemedia.p034v3.internal;

import android.net.Uri;
import com.google.android.exoplayer2.C3282C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lj */
/* loaded from: classes2.dex */
public final class C2864lj implements InterfaceC3035rs {

    /* renamed from: a */
    public final long f8008a;

    /* renamed from: b */
    public final long f8009b;

    /* renamed from: c */
    public final long f8010c;

    /* renamed from: d */
    public final boolean f8011d;

    /* renamed from: e */
    public final long f8012e;

    /* renamed from: f */
    public final long f8013f;

    /* renamed from: g */
    public final long f8014g;

    /* renamed from: h */
    public final long f8015h;

    /* renamed from: i */
    public final C2885md f8016i;

    /* renamed from: j */
    public final C2882ma f8017j;

    /* renamed from: k */
    public final Uri f8018k;

    /* renamed from: l */
    public final C2870lp f8019l;

    /* renamed from: m */
    private final List f8020m;

    public C2864lj(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, C2870lp c2870lp, C2885md c2885md, C2882ma c2882ma, Uri uri, List list) {
        this.f8008a = j;
        this.f8009b = j2;
        this.f8010c = j3;
        this.f8011d = z;
        this.f8012e = j4;
        this.f8013f = j5;
        this.f8014g = j6;
        this.f8015h = j7;
        this.f8019l = c2870lp;
        this.f8016i = c2885md;
        this.f8018k = uri;
        this.f8017j = c2882ma;
        this.f8020m = list;
    }

    /* renamed from: a */
    public final int m1712a() {
        return this.f8020m.size();
    }

    /* renamed from: b */
    public final long m1711b(int i) {
        if (i == this.f8020m.size() - 1) {
            long j = this.f8009b;
            return j == C3282C.TIME_UNSET ? C3282C.TIME_UNSET : j - ((C2869lo) this.f8020m.get(i)).f8041b;
        }
        return ((C2869lo) this.f8020m.get(i + 1)).f8041b - ((C2869lo) this.f8020m.get(i)).f8041b;
    }

    /* renamed from: c */
    public final long m1710c(int i) {
        return C2628cq.m2515s(m1711b(i));
    }

    /* renamed from: d */
    public final C2869lo m1709d(int i) {
        return (C2869lo) this.f8020m.get(i);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.InterfaceC3035rs
    /* renamed from: e */
    public final /* bridge */ /* synthetic */ Object mo1188e(List list) {
        C2864lj c2864lj = this;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new C2568ax());
        ArrayList arrayList = new ArrayList();
        long j = 0;
        int i = 0;
        while (i < m1712a()) {
            if (((C2568ax) linkedList.peek()).f5238a != i) {
                long m1711b = c2864lj.m1711b(i);
                if (m1711b != C3282C.TIME_UNSET) {
                    j += m1711b;
                }
            } else {
                C2869lo m1709d = c2864lj.m1709d(i);
                List list2 = m1709d.f8042c;
                C2568ax c2568ax = (C2568ax) linkedList.poll();
                int i2 = c2568ax.f5238a;
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    int i3 = c2568ax.f5239b;
                    C2862lh c2862lh = (C2862lh) list2.get(i3);
                    List list3 = c2862lh.f8000c;
                    ArrayList arrayList3 = new ArrayList();
                    do {
                        arrayList3.add((AbstractC2874lt) list3.get(c2568ax.f5240c));
                        c2568ax = (C2568ax) linkedList.poll();
                        if (c2568ax.f5238a != i2) {
                            break;
                        }
                    } while (c2568ax.f5239b == i3);
                    List list4 = list2;
                    arrayList2.add(new C2862lh(c2862lh.f7998a, c2862lh.f7999b, arrayList3, c2862lh.f8001d, c2862lh.f8002e, c2862lh.f8003f));
                    if (c2568ax.f5238a != i2) {
                        break;
                    }
                    list2 = list4;
                }
                linkedList.addFirst(c2568ax);
                arrayList.add(new C2869lo(m1709d.f8040a, m1709d.f8041b - j, arrayList2, m1709d.f8043d));
            }
            i++;
            c2864lj = this;
        }
        long j2 = c2864lj.f8009b;
        return new C2864lj(c2864lj.f8008a, j2 != C3282C.TIME_UNSET ? j2 - j : -9223372036854775807L, c2864lj.f8010c, c2864lj.f8011d, c2864lj.f8012e, c2864lj.f8013f, c2864lj.f8014g, c2864lj.f8015h, c2864lj.f8019l, c2864lj.f8016i, c2864lj.f8017j, c2864lj.f8018k, arrayList);
    }
}
