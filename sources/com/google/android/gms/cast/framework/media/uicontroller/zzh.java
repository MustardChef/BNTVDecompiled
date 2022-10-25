package com.google.android.gms.cast.framework.media.uicontroller;

import com.google.android.gms.cast.framework.media.widget.CastSeekBar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
public final class zzh extends com.google.android.gms.cast.framework.media.widget.zze {
    final /* synthetic */ UIMediaController zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(UIMediaController uIMediaController) {
        this.zza = uIMediaController;
    }

    @Override // com.google.android.gms.cast.framework.media.widget.zze
    public final void zza(CastSeekBar castSeekBar) {
        this.zza.zzb(castSeekBar);
    }

    @Override // com.google.android.gms.cast.framework.media.widget.zze
    public final void zzb(CastSeekBar castSeekBar) {
        this.zza.zzc(castSeekBar);
    }

    @Override // com.google.android.gms.cast.framework.media.widget.zze
    public final void zzc(CastSeekBar castSeekBar, int i, boolean z) {
        this.zza.zzd(castSeekBar, i, z);
    }
}
