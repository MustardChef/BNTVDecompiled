package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes3.dex */
final class zzkh extends zzkn {
    private final /* synthetic */ zzkc zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzkh(zzkc zzkcVar) {
        super(zzkcVar, null);
        this.zza = zzkcVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzkn, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzke(this.zza, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzkh(zzkc zzkcVar, zzkf zzkfVar) {
        this(zzkcVar);
    }
}
