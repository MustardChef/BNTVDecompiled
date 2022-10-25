package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.internal.p038firebaseauthapi.zzwk;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* loaded from: classes3.dex */
public final class zzba {
    public static MultiFactorInfo zza(zzwk zzwkVar) {
        if (zzwkVar == null || TextUtils.isEmpty(zzwkVar.zza())) {
            return null;
        }
        return new PhoneMultiFactorInfo(zzwkVar.zzb(), zzwkVar.zzc(), zzwkVar.zzd(), zzwkVar.zza());
    }

    public static List<MultiFactorInfo> zzb(List<zzwk> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (zzwk zzwkVar : list) {
            MultiFactorInfo zza = zza(zzwkVar);
            if (zza != null) {
                arrayList.add(zza);
            }
        }
        return arrayList;
    }
}
