package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public abstract class zzki extends zzkj {
    private boolean zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzki(zzkl zzklVar) {
        super(zzklVar);
        this.zza.zza(this);
    }

    protected abstract boolean zzd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzai() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzaj() {
        if (!zzai()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzak() {
        if (this.zzb) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzd();
        this.zza.zzs();
        this.zzb = true;
    }
}
