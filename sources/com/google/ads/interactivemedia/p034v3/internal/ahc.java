package com.google.ads.interactivemedia.p034v3.internal;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahc */
/* loaded from: classes2.dex */
public final class ahc implements agz {

    /* renamed from: a */
    private final int[] f4059a = new int[2];

    @Override // com.google.ads.interactivemedia.p034v3.internal.agz
    /* renamed from: a */
    public final JSONObject mo5292a(View view) {
        if (view == null) {
            return ahi.m5277b(0, 0, 0, 0);
        }
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f4059a);
        int[] iArr = this.f4059a;
        return ahi.m5277b(iArr[0], iArr[1], width, height);
    }

    @Override // com.google.ads.interactivemedia.p034v3.internal.agz
    /* renamed from: b */
    public final void mo5291b(View view, JSONObject jSONObject, agy agyVar, boolean z) {
        int i;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    agyVar.mo5247a(viewGroup.getChildAt(i2), this, jSONObject);
                }
                return;
            }
            HashMap hashMap = new HashMap();
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                View childAt = viewGroup.getChildAt(i3);
                ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
                }
                arrayList.add(childAt);
            }
            ArrayList arrayList2 = new ArrayList(hashMap.keySet());
            Collections.sort(arrayList2);
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                ArrayList arrayList3 = (ArrayList) hashMap.get((Float) arrayList2.get(i4));
                int size2 = arrayList3.size();
                int i5 = 0;
                while (true) {
                    i = i4 + 1;
                    if (i5 < size2) {
                        agyVar.mo5247a((View) arrayList3.get(i5), this, jSONObject);
                        i5++;
                    }
                }
                i4 = i;
            }
        }
    }
}
