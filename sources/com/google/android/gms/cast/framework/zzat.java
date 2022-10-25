package com.google.android.gms.cast.framework;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzat extends zzao {
    final /* synthetic */ Session zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzat(Session session, zzas zzasVar) {
        this.zza = session;
    }

    @Override // com.google.android.gms.cast.framework.zzap
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.cast.framework.zzap
    public final void zzc(Bundle bundle) {
        this.zza.onStarting(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzap
    public final void zzd(Bundle bundle) {
        this.zza.start(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzap
    public final void zze(Bundle bundle) {
        this.zza.onResuming(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzap
    public final void zzf(Bundle bundle) {
        this.zza.resume(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzap
    public final void zzg(boolean z) {
        this.zza.end(z);
    }

    @Override // com.google.android.gms.cast.framework.zzap
    public final void zzh(Bundle bundle) {
        this.zza.zza(bundle);
    }

    @Override // com.google.android.gms.cast.framework.zzap
    public final long zzi() {
        return this.zza.getSessionRemainingTimeMs();
    }
}
