package com.google.android.gms.internal.p038firebaseauthapi;

import android.app.Activity;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzux */
/* loaded from: classes3.dex */
public final class zzux {
    private static final Map<String, zzuw> zza = new ArrayMap();

    public static void zza() {
        zza.clear();
    }

    public static boolean zzb(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Activity activity, Executor executor) {
        Map<String, zzuw> map = zza;
        if (map.containsKey(str)) {
            zzuw zzuwVar = map.get(str);
            if (DefaultClock.getInstance().currentTimeMillis() - zzuwVar.zzb < 120000) {
                zzun zzunVar = zzuwVar.zza;
                if (zzunVar != null) {
                    zzunVar.zzi(onVerificationStateChangedCallbacks, activity, executor, str);
                    return true;
                }
                return true;
            }
            zze(str, null);
            return false;
        }
        zze(str, null);
        return false;
    }

    public static PhoneAuthProvider.OnVerificationStateChangedCallbacks zzc(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, zzun zzunVar) {
        zze(str, zzunVar);
        return new zzuv(onVerificationStateChangedCallbacks, str);
    }

    private static void zze(String str, zzun zzunVar) {
        zza.put(str, new zzuw(zzunVar, DefaultClock.getInstance().currentTimeMillis()));
    }
}
