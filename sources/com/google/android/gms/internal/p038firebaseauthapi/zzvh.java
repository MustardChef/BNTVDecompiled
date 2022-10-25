package com.google.android.gms.internal.p038firebaseauthapi;

import androidx.collection.ArrayMap;
import com.google.firebase.FirebaseApp;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvh */
/* loaded from: classes3.dex */
public final class zzvh {
    private static final Map<String, zzvf> zza = new ArrayMap();
    private static final Map<String, WeakReference<zzvg>> zzb = new ArrayMap();

    public static void zza(FirebaseApp firebaseApp, String str, int i) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map<String, zzvf> map = zza;
        synchronized (map) {
            map.put(apiKey, new zzvf(str, i));
        }
        Map<String, WeakReference<zzvg>> map2 = zzb;
        synchronized (map2) {
            if (map2.containsKey(apiKey)) {
                zzvg zzvgVar = map2.get(apiKey).get();
                if (zzvgVar != null) {
                    zzvgVar.zza();
                } else {
                    map.remove(apiKey);
                }
            }
        }
    }

    public static boolean zzb(FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }

    public static void zzc(String str, zzvg zzvgVar) {
        Map<String, WeakReference<zzvg>> map = zzb;
        synchronized (map) {
            map.put(str, new WeakReference<>(zzvgVar));
        }
    }

    public static String zzd(String str) {
        zzvf zzvfVar;
        String str2;
        Map<String, zzvf> map = zza;
        synchronized (map) {
            zzvfVar = map.get(str);
        }
        if (zzvfVar != null) {
            String valueOf = String.valueOf(zzh(zzvfVar.zza(), zzvfVar.zzb(), zzvfVar.zza().contains(":")));
            str2 = valueOf.length() != 0 ? "".concat(valueOf) : new String("");
        } else {
            str2 = "https://";
        }
        return String.valueOf(str2).concat("securetoken.googleapis.com/v1");
    }

    public static String zze(String str) {
        zzvf zzvfVar;
        String str2;
        Map<String, zzvf> map = zza;
        synchronized (map) {
            zzvfVar = map.get(str);
        }
        if (zzvfVar != null) {
            String valueOf = String.valueOf(zzh(zzvfVar.zza(), zzvfVar.zzb(), zzvfVar.zza().contains(":")));
            str2 = valueOf.length() != 0 ? "".concat(valueOf) : new String("");
        } else {
            str2 = "https://";
        }
        return String.valueOf(str2).concat("www.googleapis.com/identitytoolkit/v3/relyingparty");
    }

    public static String zzf(String str) {
        zzvf zzvfVar;
        String str2;
        Map<String, zzvf> map = zza;
        synchronized (map) {
            zzvfVar = map.get(str);
        }
        if (zzvfVar != null) {
            String valueOf = String.valueOf(zzh(zzvfVar.zza(), zzvfVar.zzb(), zzvfVar.zza().contains(":")));
            str2 = valueOf.length() != 0 ? "".concat(valueOf) : new String("");
        } else {
            str2 = "https://";
        }
        return String.valueOf(str2).concat("identitytoolkit.googleapis.com/v2/accounts");
    }

    public static String zzg(String str) {
        zzvf zzvfVar;
        Map<String, zzvf> map = zza;
        synchronized (map) {
            zzvfVar = map.get(str);
        }
        if (zzvfVar == null) {
            throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
        }
        return String.valueOf(zzh(zzvfVar.zza(), zzvfVar.zzb(), zzvfVar.zza().contains(":"))).concat("emulator/auth/handler");
    }

    private static String zzh(String str, int i, boolean z) {
        if (z) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("http://[");
            sb.append(str);
            sb.append("]:");
            sb.append(i);
            sb.append("/");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 20);
        sb2.append("http://");
        sb2.append(str);
        sb2.append(":");
        sb2.append(i);
        sb2.append("/");
        return sb2.toString();
    }
}
