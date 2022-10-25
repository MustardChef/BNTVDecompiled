package com.google.android.gms.internal.cast;

import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
public enum zzjq implements zzou {
    TCP_PROBING_SUMMARY_RESULT_CODE_UNKNOWN(0),
    TCP_PROBING_SUMMARY_RESULT_CODE_SKIPPED_REACHED_ATTEMPT_LIMIT(1),
    TCP_PROBING_SUMMARY_RESULT_CODE_SKIPPED_ALREADY_PUBLISHED(2),
    TCP_PROBING_SUMMARY_RESULT_CODE_SKIPPED_DISABLED(3),
    TCP_PROBING_SUMMARY_RESULT_CODE_SUCCESS(4),
    TCP_PROBING_SUMMARY_RESULT_CODE_FAIL(5);
    
    private static final zzov<zzjq> zzg = new zzov<zzjq>() { // from class: com.google.android.gms.internal.cast.zzjo
    };
    private final int zzh;

    zzjq(int i) {
        this.zzh = i;
    }

    public static zzow zza() {
        return zzjp.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + Typography.greater;
    }
}
