package com.google.firebase.analytics;

import com.google.firebase.analytics.FirebaseAnalytics;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* loaded from: classes3.dex */
final /* synthetic */ class zzc {
    static final /* synthetic */ int[] zza;

    static {
        int[] iArr = new int[FirebaseAnalytics.ConsentStatus.values().length];
        zza = iArr;
        try {
            iArr[FirebaseAnalytics.ConsentStatus.GRANTED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            zza[FirebaseAnalytics.ConsentStatus.DENIED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
