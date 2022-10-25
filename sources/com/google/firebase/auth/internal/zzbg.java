package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p038firebaseauthapi.zzlb;
import com.google.android.gms.internal.p038firebaseauthapi.zzwg;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzbg {
    private final Context zza;
    private final String zzb;
    private final SharedPreferences zzc;
    private final Logger zzd;

    public zzbg(Context context, String str) {
        Preconditions.checkNotNull(context);
        String checkNotEmpty = Preconditions.checkNotEmpty(str);
        this.zzb = checkNotEmpty;
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzc = applicationContext.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", checkNotEmpty), 0);
        this.zzd = new Logger("StorageHelpers", new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce A[Catch: zzlb -> 0x0135, IllegalArgumentException -> 0x0137, ArrayIndexOutOfBoundsException -> 0x0139, JSONException -> 0x013b, TRY_ENTER, TryCatch #2 {JSONException -> 0x013b, blocks: (B:3:0x0008, B:6:0x0025, B:10:0x003b, B:12:0x0079, B:14:0x0080, B:15:0x008c, B:16:0x008d, B:18:0x009c, B:20:0x00a5, B:21:0x00a8, B:23:0x00b1, B:28:0x00ce, B:29:0x00d1, B:31:0x00d7, B:33:0x00dd, B:34:0x00e3, B:36:0x00e9, B:38:0x0100, B:40:0x0108, B:44:0x012b, B:41:0x0122, B:42:0x0129, B:45:0x0131), top: B:59:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.firebase.auth.internal.zzx zzf(org.json.JSONObject r27) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzbg.zzf(org.json.JSONObject):com.google.firebase.auth.internal.zzx");
    }

    public final void zza(FirebaseUser firebaseUser) {
        String str;
        Preconditions.checkNotNull(firebaseUser);
        JSONObject jSONObject = new JSONObject();
        if (zzx.class.isAssignableFrom(firebaseUser.getClass())) {
            zzx zzxVar = (zzx) firebaseUser;
            try {
                jSONObject.put("cachedTokenState", zzxVar.zzg());
                jSONObject.put("applicationName", zzxVar.zzd().getName());
                jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
                if (zzxVar.zzl() != null) {
                    JSONArray jSONArray = new JSONArray();
                    List<zzt> zzl = zzxVar.zzl();
                    for (int i = 0; i < zzl.size(); i++) {
                        jSONArray.put(zzl.get(i).zzb());
                    }
                    jSONObject.put("userInfos", jSONArray);
                }
                jSONObject.put("anonymous", zzxVar.isAnonymous());
                jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, ExifInterface.GPS_MEASUREMENT_2D);
                if (zzxVar.getMetadata() != null) {
                    jSONObject.put("userMetadata", ((zzz) zzxVar.getMetadata()).zza());
                }
                List<MultiFactorInfo> enrolledFactors = new zzac(zzxVar).getEnrolledFactors();
                if (!enrolledFactors.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < enrolledFactors.size(); i2++) {
                        jSONArray2.put(enrolledFactors.get(i2).toJson());
                    }
                    jSONObject.put("userMultiFactorInfo", jSONArray2);
                }
                str = jSONObject.toString();
            } catch (Exception e) {
                this.zzd.wtf("Failed to turn object into JSON", e, new Object[0]);
                throw new zzlb(e);
            }
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzc.edit().putString("com.google.firebase.auth.FIREBASE_USER", str).apply();
    }

    public final FirebaseUser zzb() {
        String string = this.zzc.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                    return zzf(jSONObject);
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final void zzc(FirebaseUser firebaseUser, zzwg zzwgVar) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzwgVar);
        this.zzc.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), zzwgVar.zzi()).apply();
    }

    public final zzwg zzd(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String string = this.zzc.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), null);
        if (string != null) {
            return zzwg.zzj(string);
        }
        return null;
    }

    public final void zze(String str) {
        this.zzc.edit().remove(str).apply();
    }
}
