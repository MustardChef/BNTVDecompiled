package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* loaded from: classes3.dex */
public final class zzin implements Runnable {
    private final /* synthetic */ zzii zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzin(zzii zziiVar) {
        this.zza = zziiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzij zzijVar;
        zzii zziiVar = this.zza;
        zzijVar = zziiVar.zzh;
        zziiVar.zza = zzijVar;
    }
}
