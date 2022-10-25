package com.google.android.gms.internal.p038firebaseauthapi;

import java.lang.reflect.Type;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztx */
/* loaded from: classes3.dex */
public final class zztx {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zztx";

    private zztx() {
    }

    public static Object zza(String str, Type type) throws zzpp {
        if (type == String.class) {
            try {
                zzvj zzvjVar = new zzvj();
                zzvjVar.zzd(str);
                if (zzvjVar.zzb()) {
                    return zzvjVar.zzc();
                }
                String valueOf = String.valueOf(str);
                throw new zzpp(valueOf.length() != 0 ? "No error message: ".concat(valueOf) : new String("No error message: "));
            } catch (Exception e) {
                String valueOf2 = String.valueOf(e.getMessage());
                throw new zzpp(valueOf2.length() != 0 ? "Json conversion failed! ".concat(valueOf2) : new String("Json conversion failed! "), e);
            }
        } else if (type != Void.class) {
            try {
                zztz zztzVar = (zztz) ((Class) type).getConstructor(new Class[0]).newInstance(new Object[0]);
                try {
                    zztzVar.zza(str);
                    return zztzVar;
                } catch (Exception e2) {
                    String valueOf3 = String.valueOf(e2.getMessage());
                    throw new zzpp(valueOf3.length() != 0 ? "Json conversion failed! ".concat(valueOf3) : new String("Json conversion failed! "), e2);
                }
            } catch (Exception e3) {
                String valueOf4 = String.valueOf(type);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf4).length() + 38);
                sb.append("Instantiation of JsonResponse failed! ");
                sb.append(valueOf4);
                throw new zzpp(sb.toString(), e3);
            }
        } else {
            return null;
        }
    }
}
