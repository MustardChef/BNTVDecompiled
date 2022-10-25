package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
final class zzeo extends zzet<Map.Entry<K, V>> {
    private final /* synthetic */ zzem zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzeo(zzem zzemVar) {
        super(zzemVar, null);
        this.zza = zzemVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzet
    final /* synthetic */ Object zza(int i) {
        return new zzev(this.zza, i);
    }
}
