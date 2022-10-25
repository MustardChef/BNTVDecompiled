package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzkn implements zzez {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzkl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzkn(zzkl zzklVar, String str) {
        this.zzb = zzklVar;
        this.zza = str;
    }

    @Override // com.google.android.gms.measurement.internal.zzez
    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(i, th, bArr, this.zza);
    }
}
