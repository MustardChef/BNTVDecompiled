package com.google.firebase.auth.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.p038firebaseauthapi.zzlb;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
final class zzaz {
    private static final Logger zza = new Logger("JSONParser", new String[0]);

    public static Map<String, Object> zza(String str) {
        Preconditions.checkNotEmpty(str);
        List<String> zzc = com.google.android.gms.internal.p038firebaseauthapi.zzae.zza('.').zzc(str);
        if (zzc.size() < 2) {
            Logger logger = zza;
            String valueOf = String.valueOf(str);
            logger.m343e(valueOf.length() != 0 ? "Invalid idToken ".concat(valueOf) : new String("Invalid idToken "), new Object[0]);
            return new HashMap();
        }
        try {
            Map<String, Object> zzb = zzb(new String(Base64Utils.decodeUrlSafeNoPadding(zzc.get(1)), "UTF-8"));
            return zzb == null ? new HashMap() : zzb;
        } catch (UnsupportedEncodingException e) {
            zza.m344e("Unable to decode token", e, new Object[0]);
            return new HashMap();
        }
    }

    public static Map<String, Object> zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return zzc(jSONObject);
            }
            return null;
        } catch (Exception e) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new zzlb(e);
        }
    }

    static Map<String, Object> zzc(JSONObject jSONObject) throws JSONException {
        ArrayMap arrayMap = new ArrayMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = zzd((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzc((JSONObject) obj);
            }
            arrayMap.put(next, obj);
        }
        return arrayMap;
    }

    static List<Object> zzd(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = zzd((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzc((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
