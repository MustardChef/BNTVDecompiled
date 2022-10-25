package com.google.android.gms.cast.framework.media;

import android.content.DialogInterface;

/* compiled from: com.google.android.gms:play-services-cast-framework@@20.0.0 */
/* loaded from: classes2.dex */
final class zzbs implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbv zza;
    final /* synthetic */ zzbv zzb;
    final /* synthetic */ TracksChooserDialogFragment zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbs(TracksChooserDialogFragment tracksChooserDialogFragment, zzbv zzbvVar, zzbv zzbvVar2) {
        this.zzc = tracksChooserDialogFragment;
        this.zza = zzbvVar;
        this.zzb = zzbvVar2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        TracksChooserDialogFragment.zzc(this.zzc, this.zza, this.zzb);
    }
}
