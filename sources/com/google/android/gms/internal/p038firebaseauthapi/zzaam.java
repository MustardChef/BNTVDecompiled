package com.google.android.gms.internal.p038firebaseauthapi;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaam */
/* loaded from: classes3.dex */
final class zzaam {
    public static final int zza(int i, Object obj, Object obj2) {
        zzaal zzaalVar = (zzaal) obj;
        zzaak zzaakVar = (zzaak) obj2;
        if (zzaalVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzaalVar.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
        return 0;
    }

    public static final boolean zzb(Object obj) {
        return !((zzaal) obj).zze();
    }

    public static final Object zzc(Object obj, Object obj2) {
        zzaal zzaalVar = (zzaal) obj;
        zzaal zzaalVar2 = (zzaal) obj2;
        if (!zzaalVar2.isEmpty()) {
            if (!zzaalVar.zze()) {
                zzaalVar = zzaalVar.zzc();
            }
            zzaalVar.zzb(zzaalVar2);
        }
        return zzaalVar;
    }
}
