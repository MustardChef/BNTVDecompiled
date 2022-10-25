package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.google.ads.interactivemedia.p034v3.impl.data.C2518i;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahq */
/* loaded from: classes2.dex */
public final class ahq implements agy {

    /* renamed from: a */
    private static final ahq f4087a = new ahq();

    /* renamed from: b */
    private static final Handler f4088b = new Handler(Looper.getMainLooper());

    /* renamed from: c */
    private static Handler f4089c = null;

    /* renamed from: d */
    private static final Runnable f4090d = new ahn(1);

    /* renamed from: e */
    private static final Runnable f4091e = new ahn(0);

    /* renamed from: g */
    private int f4093g;

    /* renamed from: k */
    private long f4097k;

    /* renamed from: f */
    private final List f4092f = new ArrayList();

    /* renamed from: i */
    private final ahk f4095i = new ahk();

    /* renamed from: h */
    private final aha f4094h = new aha();

    /* renamed from: j */
    private final ahl f4096j = new ahl(new aht());

    ahq() {
    }

    /* renamed from: d */
    public static ahq m5244d() {
        return f4087a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* bridge */ /* synthetic */ void m5241g(ahq ahqVar) {
        ahqVar.f4093g = 0;
        ahqVar.f4097k = System.nanoTime();
        ahqVar.f4095i.m5256i();
        long nanoTime = System.nanoTime();
        agz m5294a = ahqVar.f4094h.m5294a();
        if (ahqVar.f4095i.m5260e().size() > 0) {
            Iterator it = ahqVar.f4095i.m5260e().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject mo5292a = m5294a.mo5292a(null);
                View m5264a = ahqVar.f4095i.m5264a(str);
                agz m5293b = ahqVar.f4094h.m5293b();
                String m5262c = ahqVar.f4095i.m5262c(str);
                if (m5262c != null) {
                    JSONObject mo5292a2 = m5293b.mo5292a(m5264a);
                    ahi.m5276c(mo5292a2, str);
                    ahi.m5273f(mo5292a2, m5262c);
                    ahi.m5275d(mo5292a, mo5292a2);
                }
                ahi.m5270i(mo5292a);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                ahqVar.f4096j.m5252c(mo5292a, hashSet, nanoTime);
            }
        }
        if (ahqVar.f4095i.m5259f().size() > 0) {
            JSONObject mo5292a3 = m5294a.mo5292a(null);
            ahqVar.m5237k(null, m5294a, mo5292a3, 1);
            ahi.m5270i(mo5292a3);
            ahqVar.f4096j.m5251d(mo5292a3, ahqVar.f4095i.m5259f(), nanoTime);
        } else {
            ahqVar.f4096j.m5253b();
        }
        ahqVar.f4095i.m5258g();
        long nanoTime2 = System.nanoTime() - ahqVar.f4097k;
        if (ahqVar.f4092f.size() > 0) {
            for (ahp ahpVar : ahqVar.f4092f) {
                int i = ahqVar.f4093g;
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                ahpVar.m5248b();
                if (ahpVar instanceof aho) {
                    int i2 = ahqVar.f4093g;
                    ((aho) ahpVar).m5249a();
                }
            }
        }
    }

    /* renamed from: k */
    private final void m5237k(View view, agz agzVar, JSONObject jSONObject, int i) {
        agzVar.mo5291b(view, jSONObject, this, i == 1);
    }

    /* renamed from: l */
    private static final void m5236l() {
        Handler handler = f4089c;
        if (handler != null) {
            handler.removeCallbacks(f4091e);
            f4089c = null;
        }
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.agy
    /* renamed from: a */
    public final void mo5247a(View view, agz agzVar, JSONObject jSONObject) {
        int m5255j;
        if (C2518i.m5999b(view) != null || (m5255j = this.f4095i.m5255j(view)) == 3) {
            return;
        }
        JSONObject mo5292a = agzVar.mo5292a(view);
        ahi.m5275d(jSONObject, mo5292a);
        String m5261d = this.f4095i.m5261d(view);
        if (m5261d == null) {
            ahj m5263b = this.f4095i.m5263b(view);
            if (m5263b != null) {
                ahi.m5274e(mo5292a, m5263b);
            }
            m5237k(view, agzVar, mo5292a, m5255j);
        } else {
            ahi.m5276c(mo5292a, m5261d);
            this.f4095i.m5257h();
        }
        this.f4093g++;
    }

    /* renamed from: h */
    public final void m5240h() {
        m5236l();
    }

    /* renamed from: i */
    public final void m5239i() {
        if (f4089c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f4089c = handler;
            handler.post(f4090d);
            f4089c.postDelayed(f4091e, 200L);
        }
    }

    /* renamed from: j */
    public final void m5238j() {
        m5236l();
        this.f4092f.clear();
        f4088b.post(new ahm(this));
    }
}
