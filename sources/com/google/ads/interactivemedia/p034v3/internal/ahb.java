package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;
import com.google.ads.interactivemedia.p034v3.impl.data.C2518i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahb */
/* loaded from: classes2.dex */
public final class ahb implements agz {

    /* renamed from: a */
    private final agz f4058a;

    public ahb(agz agzVar) {
        this.f4058a = agzVar;
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.agz
    /* renamed from: a */
    public final JSONObject mo5292a(View view) {
        return ahi.m5277b(0, 0, 0, 0);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.agz
    /* renamed from: b */
    public final void mo5291b(View view, JSONObject jSONObject, agy agyVar, boolean z) {
        ArrayList arrayList = new ArrayList();
        agq m5331a = agq.m5331a();
        if (m5331a != null) {
            Collection<agj> m5330b = m5331a.m5330b();
            int size = m5330b.size();
            IdentityHashMap identityHashMap = new IdentityHashMap(size + size + 3);
            for (agj agjVar : m5330b) {
                View m5344g = agjVar.m5344g();
                if (m5344g != null && (Build.VERSION.SDK_INT < 19 || m5344g.isAttachedToWindow())) {
                    if (m5344g.isShown()) {
                        View view2 = m5344g;
                        while (true) {
                            if (view2 != null) {
                                if (view2.getAlpha() != 0.0f) {
                                    ViewParent parent = view2.getParent();
                                    view2 = parent instanceof View ? (View) parent : null;
                                }
                            } else {
                                View rootView = m5344g.getRootView();
                                if (rootView != null && !identityHashMap.containsKey(rootView)) {
                                    identityHashMap.put(rootView, rootView);
                                    float m6000a = C2518i.m6000a(rootView);
                                    int size2 = arrayList.size();
                                    while (size2 > 0) {
                                        int i = size2 - 1;
                                        if (C2518i.m6000a((View) arrayList.get(i)) <= m6000a) {
                                            break;
                                        }
                                        size2 = i;
                                    }
                                    arrayList.add(size2, rootView);
                                }
                            }
                        }
                    }
                }
            }
        }
        int size3 = arrayList.size();
        for (int i2 = 0; i2 < size3; i2++) {
            agyVar.mo5247a((View) arrayList.get(i2), this.f4058a, jSONObject);
        }
    }
}
