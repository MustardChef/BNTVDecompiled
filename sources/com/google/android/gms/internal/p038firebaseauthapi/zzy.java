package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzy */
/* loaded from: classes3.dex */
final class zzy extends zzac {
    final /* synthetic */ zzz zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzy(zzz zzzVar, zzae zzaeVar, CharSequence charSequence) {
        super(zzaeVar, charSequence);
        this.zza = zzzVar;
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzac
    final int zzc(int i) {
        String zzc;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        if (i >= 0 && i <= length) {
            while (i < length) {
                if (charSequence.charAt(i) == '.') {
                    return i;
                }
                i++;
            }
            return -1;
        }
        if (i < 0) {
            zzc = zzaf.zzc("%s (%s) must not be negative", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i));
        } else if (length < 0) {
            StringBuilder sb = new StringBuilder(26);
            sb.append("negative size: ");
            sb.append(length);
            throw new IllegalArgumentException(sb.toString());
        } else {
            zzc = zzaf.zzc("%s (%s) must not be greater than size (%s)", FirebaseAnalytics.Param.INDEX, Integer.valueOf(i), Integer.valueOf(length));
        }
        throw new IndexOutOfBoundsException(zzc);
    }

    @Override // com.google.android.gms.internal.p038firebaseauthapi.zzac
    final int zzd(int i) {
        return i + 1;
    }
}
