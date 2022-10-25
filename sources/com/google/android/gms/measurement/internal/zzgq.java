package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public abstract class zzgq extends zzgr {
    private boolean zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgq(zzfu zzfuVar) {
        super(zzfuVar);
        this.zzy.zza(this);
    }

    /* renamed from: g_ */
    protected void mo330g_() {
    }

    protected abstract boolean zzd();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzaa() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzab() {
        if (!zzaa()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzac() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (zzd()) {
            return;
        }
        this.zzy.zzae();
        this.zza = true;
    }

    public final void zzad() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo330g_();
        this.zzy.zzae();
        this.zza = true;
    }
}
