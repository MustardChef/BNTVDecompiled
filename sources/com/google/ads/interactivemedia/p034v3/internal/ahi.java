package com.google.ads.interactivemedia.p034v3.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.view.WindowManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.ads.interactivemedia.p034v3.impl.data.C2518i;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IMASDK */
/* renamed from: com.google.ads.interactivemedia.v3.internal.ahi */
/* loaded from: classes2.dex */
public final class ahi {

    /* renamed from: b */
    private static WindowManager f4071b;

    /* renamed from: c */
    private static final String[] f4072c = {"x", "y", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY};

    /* renamed from: a */
    static float f4070a = Resources.getSystem().getDisplayMetrics().density;

    /* renamed from: a */
    static float m5278a(int i) {
        return i / f4070a;
    }

    /* renamed from: b */
    public static JSONObject m5277b(int i, int i2, int i3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", m5278a(i));
            jSONObject.put("y", m5278a(i2));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, m5278a(i3));
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, m5278a(i4));
        } catch (JSONException e) {
            C2518i.m5996e("Error with creating viewStateObject", e);
        }
        return jSONObject;
    }

    /* renamed from: c */
    public static void m5276c(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("adSessionId", str);
        } catch (JSONException e) {
            C2518i.m5996e("Error with setting ad session id", e);
        }
    }

    /* renamed from: d */
    public static void m5275d(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
                jSONObject.put("childViews", optJSONArray);
            }
            optJSONArray.put(jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: e */
    public static void m5274e(JSONObject jSONObject, ahj ahjVar) {
        agt m5267a = ahjVar.m5267a();
        JSONArray jSONArray = new JSONArray();
        ArrayList m5266b = ahjVar.m5266b();
        int size = m5266b.size();
        for (int i = 0; i < size; i++) {
            jSONArray.put((String) m5266b.get(i));
        }
        try {
            jSONObject.put("isFriendlyObstructionFor", jSONArray);
            jSONObject.put("friendlyObstructionClass", m5267a.m5314c());
            jSONObject.put("friendlyObstructionPurpose", m5267a.m5316a());
            jSONObject.put("friendlyObstructionReason", m5267a.m5315b());
        } catch (JSONException e) {
            C2518i.m5996e("Error with setting friendly obstruction", e);
        }
    }

    /* renamed from: f */
    public static void m5273f(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("notVisibleReason", str);
        } catch (JSONException e) {
            C2518i.m5996e("Error with setting not visible reason", e);
        }
    }

    /* renamed from: g */
    public static void m5272g(Context context) {
        if (context != null) {
            f4070a = context.getResources().getDisplayMetrics().density;
            f4071b = (WindowManager) context.getSystemService("window");
        }
    }

    /* renamed from: h */
    public static void m5271h(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 47);
            sb.append("JSONException during JSONObject.put for name [");
            sb.append(str);
            sb.append("]");
            C2518i.m5996e(sb.toString(), e);
        }
    }

    /* renamed from: i */
    public static void m5270i(JSONObject jSONObject) {
        float f;
        float f2 = 0.0f;
        if (Build.VERSION.SDK_INT >= 17) {
            if (f4071b != null) {
                Point point = new Point(0, 0);
                f4071b.getDefaultDisplay().getRealSize(point);
                f2 = m5278a(point.x);
                f = m5278a(point.y);
            }
            f = 0.0f;
        } else {
            JSONArray optJSONArray = jSONObject.optJSONArray("childViews");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                float f3 = 0.0f;
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        double optDouble = optJSONObject.optDouble("x");
                        double optDouble2 = optJSONObject.optDouble("y");
                        double optDouble3 = optJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                        double optDouble4 = optJSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                        f2 = Math.max(f2, (float) (optDouble + optDouble3));
                        f3 = Math.max(f3, (float) (optDouble2 + optDouble4));
                    }
                }
                f = f3;
            }
            f = 0.0f;
        }
        ahh ahhVar = new ahh(f2, f);
        try {
            jSONObject.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ahhVar.f4068a);
            jSONObject.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, ahhVar.f4069b);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    public static boolean m5269j(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject != null && jSONObject2 != null) {
            String[] strArr = f4072c;
            int i = 0;
            while (true) {
                if (i < 4) {
                    String str = strArr[i];
                    if (jSONObject.optDouble(str) != jSONObject2.optDouble(str)) {
                        break;
                    }
                    i++;
                } else if (jSONObject.optString("adSessionId", "").equals(jSONObject2.optString("adSessionId", ""))) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("isFriendlyObstructionFor");
                    JSONArray optJSONArray2 = jSONObject2.optJSONArray("isFriendlyObstructionFor");
                    if (optJSONArray != null || optJSONArray2 != null) {
                        if (m5268k(optJSONArray, optJSONArray2)) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                if (!optJSONArray.optString(i2, "").equals(optJSONArray2.optString(i2, ""))) {
                                    break;
                                }
                            }
                        }
                    }
                    JSONArray optJSONArray3 = jSONObject.optJSONArray("childViews");
                    JSONArray optJSONArray4 = jSONObject2.optJSONArray("childViews");
                    if (optJSONArray3 != null || optJSONArray4 != null) {
                        if (m5268k(optJSONArray3, optJSONArray4)) {
                            for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                if (m5269j(optJSONArray3.optJSONObject(i3), optJSONArray4.optJSONObject(i3))) {
                                }
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: k */
    private static boolean m5268k(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        return (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) ? false : true;
    }
}
