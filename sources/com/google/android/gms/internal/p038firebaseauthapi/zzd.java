package com.google.android.gms.internal.p038firebaseauthapi;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzd */
/* loaded from: classes3.dex */
public final class zzd {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature[] zzd;

    static {
        Feature feature = new Feature("firebase_auth", 11L);
        zza = feature;
        Feature feature2 = new Feature("firebase_auth_aidl_migration", 1L);
        zzb = feature2;
        Feature feature3 = new Feature("firebase_auth_multi_factor_auth", 1L);
        zzc = feature3;
        zzd = new Feature[]{feature, feature2, feature3};
    }
}
