package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzww */
/* loaded from: classes3.dex */
public final class zzww implements zzty {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private final zzxe zzg = new zzxe(null);
    private final zzxe zzh = new zzxe(null);
    private String zzi;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzty
    public final String zza() throws JSONException {
        char c;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("returnSecureToken", true);
        if (!this.zzh.zza().isEmpty()) {
            List<String> zza = this.zzh.zza();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < zza.size(); i++) {
                jSONArray.put(zza.get(i));
            }
            jSONObject.put("deleteProvider", jSONArray);
        }
        List<String> zza2 = this.zzg.zza();
        int size = zza2.size();
        int[] iArr = new int[size];
        for (int i2 = 0; i2 < zza2.size(); i2++) {
            String str = zza2.get(i2);
            int i3 = 2;
            switch (str.hashCode()) {
                case -333046776:
                    if (str.equals("DISPLAY_NAME")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 66081660:
                    if (str.equals("EMAIL")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1939891618:
                    if (str.equals("PHOTO_URL")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 1999612571:
                    if (str.equals("PASSWORD")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                i3 = 1;
            } else if (c != 1) {
                i3 = c != 2 ? c != 3 ? 0 : 4 : 5;
            }
            iArr[i2] = i3;
        }
        if (size > 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i4 = 0; i4 < size; i4++) {
                jSONArray2.put(iArr[i4]);
            }
            jSONObject.put("deleteAttribute", jSONArray2);
        }
        String str2 = this.zza;
        if (str2 != null) {
            jSONObject.put("idToken", str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("email", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("password", str4);
        }
        String str5 = this.zzb;
        if (str5 != null) {
            jSONObject.put("displayName", str5);
        }
        String str6 = this.zzf;
        if (str6 != null) {
            jSONObject.put("photoUrl", str6);
        }
        String str7 = this.zze;
        if (str7 != null) {
            jSONObject.put("oobCode", str7);
        }
        String str8 = this.zzi;
        if (str8 != null) {
            jSONObject.put("tenantId", str8);
        }
        return jSONObject.toString();
    }

    public final boolean zzb(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzg.zza().contains(str);
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final String zze() {
        return this.zzb;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final zzww zzg(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzww zzh(String str) {
        if (str == null) {
            this.zzg.zza().add("EMAIL");
        } else {
            this.zzc = str;
        }
        return this;
    }

    public final zzww zzi(String str) {
        if (str == null) {
            this.zzg.zza().add("PASSWORD");
        } else {
            this.zzd = str;
        }
        return this;
    }

    public final zzww zzj(String str) {
        if (str == null) {
            this.zzg.zza().add("DISPLAY_NAME");
        } else {
            this.zzb = str;
        }
        return this;
    }

    public final zzww zzk(String str) {
        if (str == null) {
            this.zzg.zza().add("PHOTO_URL");
        } else {
            this.zzf = str;
        }
        return this;
    }

    public final zzww zzl(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzh.zza().add(str);
        return this;
    }

    public final zzww zzm(String str) {
        this.zze = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzww zzn(String str) {
        this.zzi = str;
        return this;
    }
}
