package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@20.0.0 */
/* loaded from: classes3.dex */
final class zzdi<E> extends zzdd<E> {
    private final zzdk<E> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdi(zzdk<E> zzdkVar, int i) {
        super(zzdkVar.size(), i);
        this.zza = zzdkVar;
    }

    @Override // com.google.android.gms.internal.cast.zzdd
    protected final E zza(int i) {
        return this.zza.get(i);
    }
}
