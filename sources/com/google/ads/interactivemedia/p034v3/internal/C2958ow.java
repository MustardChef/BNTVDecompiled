package com.google.ads.interactivemedia.p034v3.internal;

import android.util.Pair;
import com.fasterxml.jackson.core.JsonPointer;
import com.google.android.exoplayer2.C3282C;
import com.google.android.exoplayer2.drm.WidevineUtil;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ow */
/* loaded from: classes2.dex */
public final /* synthetic */ class C2958ow {
    /* renamed from: a */
    public static Pair m1438a(InterfaceC2910nb interfaceC2910nb) {
        Map mo1573d = interfaceC2910nb.mo1573d();
        if (mo1573d == null) {
            return null;
        }
        return new Pair(Long.valueOf(m1434e(mo1573d, WidevineUtil.PROPERTY_LICENSE_DURATION_REMAINING)), Long.valueOf(m1434e(mo1573d, WidevineUtil.PROPERTY_PLAYBACK_DURATION_REMAINING)));
    }

    /* renamed from: b */
    public static void m1437b(InterfaceC2910nb interfaceC2910nb, InterfaceC2910nb interfaceC2910nb2) {
        if (interfaceC2910nb == interfaceC2910nb2) {
            return;
        }
        if (interfaceC2910nb2 != null) {
            interfaceC2910nb2.mo1571h(null);
        }
        if (interfaceC2910nb != null) {
            interfaceC2910nb.mo1570m(null);
        }
    }

    /* renamed from: c */
    public static byte[] m1436c(byte[] bArr) {
        if (C2628cq.f6961a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(C2628cq.m2576G(bArr));
            StringBuilder sb = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (i != 0) {
                    sb.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                sb.append("{\"k\":\"");
                sb.append(m1433f(jSONObject2.getString("k")));
                sb.append("\",\"kid\":\"");
                sb.append(m1433f(jSONObject2.getString("kid")));
                sb.append("\",\"kty\":\"");
                sb.append(jSONObject2.getString("kty"));
                sb.append("\"}");
            }
            sb.append("]}");
            return C2628cq.m2554ab(sb.toString());
        } catch (JSONException e) {
            String m2576G = C2628cq.m2576G(bArr);
            C2613cb.m2698a("ClearKeyUtil", m2576G.length() != 0 ? "Failed to adjust response data: ".concat(m2576G) : new String("Failed to adjust response data: "), e);
            return bArr;
        }
    }

    /* renamed from: d */
    public static C2642dd m1435d(AbstractC2874lt abstractC2874lt, String str, C2871lq c2871lq, int i) {
        C2641dc c2641dc = new C2641dc();
        c2641dc.m2492i(c2871lq.m1678a(str));
        c2641dc.m2493h(c2871lq.f8049a);
        c2641dc.m2494g(c2871lq.f8050b);
        abstractC2874lt.mo1673m();
        c2641dc.m2495f(c2871lq.m1678a(((C2863li) abstractC2874lt.f8058c.get(0)).f8004a).toString());
        c2641dc.m2499b(i);
        return c2641dc.m2500a();
    }

    /* renamed from: e */
    private static long m1434e(Map map, String str) {
        try {
            String str2 = (String) map.get(str);
            return str2 != null ? Long.parseLong(str2) : C3282C.TIME_UNSET;
        } catch (NumberFormatException unused) {
            return C3282C.TIME_UNSET;
        }
    }

    /* renamed from: f */
    private static String m1433f(String str) {
        return str.replace('-', '+').replace('_', JsonPointer.SEPARATOR);
    }
}
