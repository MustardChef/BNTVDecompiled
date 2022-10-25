package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.C3282C;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.lg */
/* loaded from: classes2.dex */
public final class C2861lg implements Handler.Callback {

    /* renamed from: a */
    private final InterfaceC2859le f7988a;

    /* renamed from: e */
    private C2864lj f7992e;

    /* renamed from: f */
    private long f7993f;

    /* renamed from: g */
    private boolean f7994g;

    /* renamed from: h */
    private boolean f7995h;

    /* renamed from: i */
    private boolean f7996i;

    /* renamed from: j */
    private final C3154wc f7997j;

    /* renamed from: d */
    private final TreeMap f7991d = new TreeMap();

    /* renamed from: c */
    private final Handler f7990c = C2628cq.m2582A(this);

    /* renamed from: b */
    private final aab f7989b = new aab();

    public C2861lg(C2864lj c2864lj, InterfaceC2859le interfaceC2859le, C3154wc c3154wc) {
        this.f7992e = c2864lj;
        this.f7988a = interfaceC2859le;
        this.f7997j = c3154wc;
    }

    /* renamed from: i */
    private final void m1713i() {
        if (this.f7994g) {
            this.f7995h = true;
            this.f7994g = false;
            ((C2843kp) this.f7988a).f7899a.m1756j();
        }
    }

    /* renamed from: b */
    public final C2860lf m1720b() {
        return new C2860lf(this, this.f7997j);
    }

    /* renamed from: d */
    public final void m1718d() {
        this.f7996i = true;
        this.f7990c.removeCallbacksAndMessages(null);
    }

    /* renamed from: e */
    public final void m1717e(C2864lj c2864lj) {
        this.f7995h = false;
        this.f7993f = C3282C.TIME_UNSET;
        this.f7992e = c2864lj;
        Iterator it = this.f7991d.entrySet().iterator();
        while (it.hasNext()) {
            if (((Long) ((Map.Entry) it.next()).getKey()).longValue() < this.f7992e.f8015h) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final boolean m1716f(long j) {
        C2864lj c2864lj = this.f7992e;
        boolean z = false;
        if (c2864lj.f8011d) {
            if (this.f7995h) {
                return true;
            }
            Map.Entry ceilingEntry = this.f7991d.ceilingEntry(Long.valueOf(c2864lj.f8015h));
            if (ceilingEntry != null && ((Long) ceilingEntry.getValue()).longValue() < j) {
                long longValue = ((Long) ceilingEntry.getKey()).longValue();
                this.f7993f = longValue;
                ((C2843kp) this.f7988a).f7899a.m1757i(longValue);
                z = true;
            }
            if (z) {
                m1713i();
            }
            return z;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final boolean m1715g(boolean z) {
        if (this.f7992e.f8011d) {
            if (this.f7995h) {
                return true;
            }
            if (z) {
                m1713i();
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public final void m1714h() {
        this.f7994g = true;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (this.f7996i) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        C2858ld c2858ld = (C2858ld) message.obj;
        long j = c2858ld.f7981a;
        long j2 = c2858ld.f7982b;
        TreeMap treeMap = this.f7991d;
        Long valueOf = Long.valueOf(j2);
        Long l = (Long) treeMap.get(valueOf);
        if (l == null) {
            this.f7991d.put(valueOf, Long.valueOf(j));
        } else if (l.longValue() > j) {
            this.f7991d.put(valueOf, Long.valueOf(j));
        }
        return true;
    }
}
